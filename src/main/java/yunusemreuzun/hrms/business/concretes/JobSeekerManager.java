package yunusemreuzun.hrms.business.concretes;

import java.rmi.RemoteException;
import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.JobSeekerUserService;
import yunusemreuzun.hrms.business.concretes.senders.VerificationEmailSender;
import yunusemreuzun.hrms.business.concretes.validators.JobSeekerUserValidator;
import yunusemreuzun.hrms.core.utilities.generators.RandomStringGenerator;
import yunusemreuzun.hrms.core.utilities.results.ErrorResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.core.utilities.results.SuccessDataResult;
import yunusemreuzun.hrms.core.utilities.results.SuccessResult;
import yunusemreuzun.hrms.dataAccess.abstracts.JobSeekerUserDao;
import yunusemreuzun.hrms.dataAccess.abstracts.VerificationTokenDao;
import yunusemreuzun.hrms.entities.concretes.JobSeekerUser;
import yunusemreuzun.hrms.entities.concretes.VerificationToken;

@Service
public class JobSeekerManager implements JobSeekerUserService{

	private JobSeekerUserDao jobSeekerUserDao;
	private VerificationTokenDao verificationTokenDao;
	private JobSeekerUserValidator jobSeekerUserValidator;
	private VerificationEmailSender verificationEmailSender;
	
	@Autowired
	public JobSeekerManager(JobSeekerUserDao jobSeekerUserDao, JobSeekerUserValidator jobSeekerUserValidator, VerificationTokenDao verificationTokenDao,VerificationEmailSender verificationEmailSender) {
		this.jobSeekerUserDao = jobSeekerUserDao;
		this.jobSeekerUserValidator = jobSeekerUserValidator;
		this.verificationTokenDao = verificationTokenDao;
		this.verificationEmailSender = verificationEmailSender;
	}

	@Override
	public Result register(JobSeekerUser jobSeekerUser) {
		if(!jobSeekerUserValidator.validateIfFieldsNotEmpty(jobSeekerUser)) {
			return new ErrorResult("Tüm alanlar zorunludur.");
		}
		try {
			if(!jobSeekerUserValidator.validateUserIdentity(jobSeekerUser)) {
				return new ErrorResult("Kimlik bilgileri doğrulanamadı.");
			}
		} catch (RemoteException e) {
			return new ErrorResult("Kimlik bilgileri doğrulanırken bir sorun oluştu.");
		}
		if(jobSeekerUserDao.existsByEmail(jobSeekerUser.getEmail())) {
			return new ErrorResult("Bu e-posta adresi kullanılıyor.");
		}
		if(jobSeekerUserDao.existsByNationalIdentity(jobSeekerUser.getNationalIdentity())) {
			return new ErrorResult("Bu kimlik numarası kullanılıyor.");
		}
		jobSeekerUserDao.save(jobSeekerUser);
		Map<String,String> token = Collections.singletonMap("token", new RandomStringGenerator().generateRandomAlphanumericString(100));
		verificationTokenDao.save(new VerificationToken(jobSeekerUserDao.findByEmail(jobSeekerUser.getEmail()).stream().findFirst().get().getId(),token.get("token")));
		verificationEmailSender.send(jobSeekerUser.getEmail(), token.get("token"));
		return new SuccessDataResult<Map<String, String>>(token,"Başarıyla kayıt olundu. ");
	}

	@Override
	public Result verify(String token) {
		try {
			int userId = verificationTokenDao.findByToken(token).stream().findFirst().get().getUserId();
			JobSeekerUser user = jobSeekerUserDao.findById(userId);
			user.setActive(true);
			jobSeekerUserDao.save(user);
			verificationTokenDao.deleteById(userId);
		} catch (NoSuchElementException e) {
			return new ErrorResult("Doğrulama kodu bulunamadı.");
		}
		return new SuccessResult("Doğrulama başarılı");
	}

}
