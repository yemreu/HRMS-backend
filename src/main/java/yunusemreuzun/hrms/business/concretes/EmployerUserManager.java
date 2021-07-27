package yunusemreuzun.hrms.business.concretes;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.EmployerUserService;
import yunusemreuzun.hrms.business.concretes.senders.VerificationEmailSender;
import yunusemreuzun.hrms.business.concretes.validators.EmployerUserValidator;
import yunusemreuzun.hrms.core.utilities.generators.RandomStringGenerator;
import yunusemreuzun.hrms.core.utilities.results.DataResult;
import yunusemreuzun.hrms.core.utilities.results.ErrorDataResult;
import yunusemreuzun.hrms.core.utilities.results.ErrorResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.core.utilities.results.SuccessDataResult;
import yunusemreuzun.hrms.core.utilities.results.SuccessResult;
import yunusemreuzun.hrms.dataAccess.abstracts.EmployerUserDao;
import yunusemreuzun.hrms.dataAccess.abstracts.EmployerUserProfileUpdateDao;
import yunusemreuzun.hrms.dataAccess.abstracts.VerificationTokenDao;
import yunusemreuzun.hrms.entities.concretes.EmployerUser;
import yunusemreuzun.hrms.entities.concretes.EmployerUserProfileUpdate;
import yunusemreuzun.hrms.entities.concretes.VerificationToken;
import yunusemreuzun.hrms.entities.dtos.EmployerUserDto;
import yunusemreuzun.hrms.entities.dtos.EmployerUserProfileUpdateDto;

@Service
public class EmployerUserManager implements EmployerUserService{

	private EmployerUserDao employerUserDao;
	private EmployerUserProfileUpdateDao employerUserProfileUpdateDao;
	private VerificationTokenDao verificationTokenDao;
	private EmployerUserValidator employerUserValidator;
	private VerificationEmailSender verificationEmailSender;

	@Autowired
	public EmployerUserManager(EmployerUserDao employerUserDao,EmployerUserValidator employerUserValidator,VerificationTokenDao verificationTokenDao,VerificationEmailSender verificationEmailSender, EmployerUserProfileUpdateDao employerUserProfileUpdateDao) {
		this.employerUserDao = employerUserDao;
		this.employerUserValidator = employerUserValidator;
		this.verificationTokenDao = verificationTokenDao;
		this.verificationEmailSender = verificationEmailSender;
		this.employerUserProfileUpdateDao = employerUserProfileUpdateDao;
	}

	@Override
	public Result register(EmployerUser employerUser) {
		/*if(!employerUserValidator.validateIfFieldsNotEmpty(employerUser)) {
			return new ErrorResult("Tüm alanlar zorunludur.");
		}*/
		if(!employerUserValidator.validateIfCompanyEmail(employerUser)) {
			return new ErrorResult("Email şirketinize ait değil.");
		}
		if(employerUserDao.existsByEmail(employerUser.getEmail())) {
			return new ErrorResult("Bu e-posta adresi kullanılıyor.");
		}
		employerUserDao.save(employerUser);
		Map<String,String> token = Collections.singletonMap("token", new RandomStringGenerator().generateRandomAlphanumericString(100));
		verificationTokenDao.save(new VerificationToken(employerUserDao.getByEmail(employerUser.getEmail()).stream().findFirst().get().getId(),token.get("token")));
		verificationEmailSender.send(employerUser.getEmail(), token.get("token"));
		return new SuccessDataResult<Map<String, String>>(token,"Başarıyla kayıt olundu. ");
	}
	
	@Override
	public Result verify(int companyId) {
		EmployerUser user = employerUserDao.getById(companyId);
		user.setVerifiedCompany(true);
		employerUserDao.save(user);
		return new SuccessResult("Şirket doğrulaması başarılı");
	}
	
	@Override
	public DataResult<List<EmployerUser>> getAll() {
		return new SuccessDataResult<List<EmployerUser>>(employerUserDao.findAll(), "İşverenler listelendi.");
	}

	@Override
	public DataResult<List<EmployerUserDto>> getAllEmployerUserData() {
		return new SuccessDataResult<List<EmployerUserDto>>(employerUserDao.getAllEmployerUserData(), "İşverenler listelendi.");
	}
	
	@Override
	public DataResult<EmployerUserDto> getEmployerUserData(int userId) {
		return new SuccessDataResult<EmployerUserDto>(employerUserDao.getEmployerUserData(userId), "İşveren listelendi.");
	}
	

	@Override
	public Result update(EmployerUserProfileUpdate profileUpdate) {
		if(!employerUserDao.existsById(profileUpdate.getEmployerUser().getId())) return new ErrorResult("İşveren mevcut değil.");
		EmployerUserProfileUpdate update;
		if(employerUserProfileUpdateDao.existsByEmployerUser_Id(profileUpdate.getEmployerUser().getId())) {
			update = employerUserProfileUpdateDao.getByEmployerUser_Id(profileUpdate.getEmployerUser().getId());
			if(!profileUpdate.getCompanyName().isEmpty()) update.setCompanyName(profileUpdate.getCompanyName());
			if(!profileUpdate.getWebsite().isEmpty()) update.setWebsite(profileUpdate.getWebsite());
			if(!profileUpdate.getPhoneNumber().isEmpty()) update.setPhoneNumber(profileUpdate.getPhoneNumber());
		}else {
			update = new EmployerUserProfileUpdate(0,profileUpdate.getCompanyName(), profileUpdate.getWebsite(), profileUpdate.getPhoneNumber(), profileUpdate.getEmployerUser());
		}
		employerUserProfileUpdateDao.save(update);
		return new SuccessResult("Profil güncellemesi kaydedildi.");
	}
	
	@Override
	public DataResult<EmployerUserProfileUpdateDto> getEmployerProfileUpdateData(int id) {
		if(!employerUserProfileUpdateDao.existsById(id)) return new ErrorDataResult<EmployerUserProfileUpdateDto>("İşveren profil güncellemesi mevcut değil.");
		return new SuccessDataResult<EmployerUserProfileUpdateDto>(employerUserProfileUpdateDao.getEmployerUserProfileUpdateData(id),"İşveren profil güncellenmesi listelendi.");
	}

	@Override
	public DataResult<List<EmployerUserProfileUpdateDto>> getEmployerUserProfileUpdatesData() {
		return new SuccessDataResult<List<EmployerUserProfileUpdateDto>>(employerUserProfileUpdateDao.getEmployerUserProfileUpdatesData(), "İşveren profil güncellemeleri listelendi.");
	}

	@Override
	public Result approveProfileUpdate(int profileUpdateId) {
		if(!employerUserProfileUpdateDao.existsById(profileUpdateId)) return new ErrorDataResult<EmployerUserProfileUpdateDto>("İşveren profil güncellemesi mevcut değil.");
		EmployerUserProfileUpdate employerUserProfileUpdate = employerUserProfileUpdateDao.getById(profileUpdateId);
		EmployerUser employerUser = employerUserDao.getById(employerUserProfileUpdate.getEmployerUser().getId());
		if(!employerUserProfileUpdate.getCompanyName().isEmpty()) employerUser.setCompanyName(employerUserProfileUpdate.getCompanyName());
		if(!employerUserProfileUpdate.getWebsite().isEmpty()) employerUser.setWebsite(employerUserProfileUpdate.getWebsite());
		if(!employerUserProfileUpdate.getPhoneNumber().isEmpty()) employerUser.setPhoneNumber(employerUserProfileUpdate.getPhoneNumber());
		employerUserDao.save(employerUser);
		employerUserProfileUpdateDao.deleteById(profileUpdateId);
		return new SuccessResult("İşveren profil güncellemesi onaylandı.");
	}

	@Override
	public Result existsEmployerProfileUpdate(int userId) {
		if(employerUserProfileUpdateDao.existsByEmployerUser_Id(userId)) return new SuccessResult();
		return new ErrorResult();
	}

}
