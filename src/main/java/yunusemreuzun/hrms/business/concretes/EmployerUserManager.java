package yunusemreuzun.hrms.business.concretes;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.EmployerUserService;
import yunusemreuzun.hrms.business.concretes.senders.VerificationEmailSender;
import yunusemreuzun.hrms.business.concretes.validators.EmployerUserValidator;
import yunusemreuzun.hrms.core.utilities.generators.RandomStringGenerator;
import yunusemreuzun.hrms.core.utilities.results.ErrorResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.core.utilities.results.SuccessDataResult;
import yunusemreuzun.hrms.core.utilities.results.SuccessResult;
import yunusemreuzun.hrms.dataAccess.abstracts.EmployerUserDao;
import yunusemreuzun.hrms.dataAccess.abstracts.VerificationTokenDao;
import yunusemreuzun.hrms.entities.concretes.EmployerUser;
import yunusemreuzun.hrms.entities.concretes.VerificationToken;

@Service
public class EmployerUserManager implements EmployerUserService{

	private EmployerUserDao employerUserDao;
	private VerificationTokenDao verificationTokenDao;
	private EmployerUserValidator employerUserValidator;
	private VerificationEmailSender verificationEmailSender;

	@Autowired
	public EmployerUserManager(EmployerUserDao employerUserDao,EmployerUserValidator employerUserValidator,VerificationTokenDao verificationTokenDao,VerificationEmailSender verificationEmailSender) {
		this.employerUserDao = employerUserDao;
		this.employerUserValidator = employerUserValidator;
		this.verificationTokenDao = verificationTokenDao;
		this.verificationEmailSender = verificationEmailSender;
	}

	@Override
	public Result register(EmployerUser employerUser) {
		if(!employerUserValidator.validateIfFieldsNotEmpty(employerUser)) {
			return new ErrorResult("Tüm alanlar zorunludur.");
		}
		if(!employerUserValidator.validateIfCompanyEmail(employerUser)) {
			return new ErrorResult("Email şirketinize ait değil.");
		}
		if(employerUserDao.existsByEmail(employerUser.getEmail())) {
			return new ErrorResult("Bu e-posta adresi kullanılıyor.");
		}
		employerUserDao.save(employerUser);
		Map<String,String> token = Collections.singletonMap("token", new RandomStringGenerator().generateRandomAlphanumericString(100));
		verificationTokenDao.save(new VerificationToken(employerUserDao.findByEmail(employerUser.getEmail()).stream().findFirst().get().getId(),token.get("token")));
		verificationEmailSender.send(employerUser.getEmail(), token.get("token"));
		return new SuccessDataResult<Map<String, String>>(token,"Başarıyla kayıt olundu. ");
	}
	
	@Override
	public Result verify(int companyId) {
		EmployerUser user = employerUserDao.findById(companyId);
		user.setVerifiedCompany(true);
		employerUserDao.save(user);
		return new SuccessResult("Şirket doğrulaması başarılı");
	}
	
}
