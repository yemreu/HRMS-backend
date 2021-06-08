package yunusemreuzun.hrms.business.concretes;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.UserVerificationService;
import yunusemreuzun.hrms.core.utilities.results.ErrorResult;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.core.utilities.results.SuccessResult;
import yunusemreuzun.hrms.dataAccess.abstracts.UserDao;
import yunusemreuzun.hrms.dataAccess.abstracts.VerificationTokenDao;
import yunusemreuzun.hrms.entities.concretes.User;

@Service
public class UserVerificationManager implements UserVerificationService{

	private UserDao userDao;
	private VerificationTokenDao verificationTokenDao;
	
	@Autowired
	public UserVerificationManager(UserDao userDao,VerificationTokenDao verificationTokenDao) {
		this.userDao = userDao;
		this.verificationTokenDao = verificationTokenDao;
	}

	@Override
	public Result verify(String token) {
		try {
			int id = verificationTokenDao.getByToken(token).stream().findFirst().get().getUserId();
			User user = userDao.getById(id);
			user.setActive(true);
			userDao.save(user);
			verificationTokenDao.deleteById(id);
		} catch (NoSuchElementException e) {
			return new ErrorResult("Doğrulama kodu bulunamadı.");
		}
		return new SuccessResult("Doğrulama başarılı");
	}

}
