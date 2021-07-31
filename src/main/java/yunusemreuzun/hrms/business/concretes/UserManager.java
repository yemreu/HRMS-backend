package yunusemreuzun.hrms.business.concretes;

import org.springframework.stereotype.Service;

import yunusemreuzun.hrms.business.abstracts.UserService;
import yunusemreuzun.hrms.core.utilities.results.Result;
import yunusemreuzun.hrms.core.utilities.results.SuccessResult;
import yunusemreuzun.hrms.dataAccess.abstracts.UserDao;
import yunusemreuzun.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Result updateEmail(int userId, String email) {
		User user = userDao.getById(userId);
		user.setEmail(email);
		userDao.save(user);
		return new SuccessResult("Email güncellendi.");
	}

	@Override
	public Result updatePassword(int userId, String password) {
		User user = userDao.getById(userId);
		user.setPassword(password);
		userDao.save(user);
		return new SuccessResult("Parola güncellendi.");
	}

	
}
