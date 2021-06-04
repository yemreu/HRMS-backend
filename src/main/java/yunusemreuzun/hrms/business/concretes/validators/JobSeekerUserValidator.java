package yunusemreuzun.hrms.business.concretes.validators;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import yunusemreuzun.hrms.business.abstracts.UserIdentityCheckService;
import yunusemreuzun.hrms.business.abstracts.validators.UserValidator;
import yunusemreuzun.hrms.entities.concretes.JobSeekerUser;

@Component
public class JobSeekerUserValidator implements UserValidator {

	private UserIdentityCheckService userIdentityCheckService;

	@Autowired
	public JobSeekerUserValidator(UserIdentityCheckService userIdentityCheckService) {
		this.userIdentityCheckService = userIdentityCheckService;
	}

	public boolean validateIfFieldsNotEmpty(JobSeekerUser user) {
		if (ObjectUtils.isEmpty(user.getEmail()) || ObjectUtils.isEmpty(user.getPassword())
				|| ObjectUtils.isEmpty(user.getFirstName()) || ObjectUtils.isEmpty(user.getLastName())
				|| ObjectUtils.isEmpty(user.getNationalIdentity()) || ObjectUtils.isEmpty(user.getYearOfBirth())) {
			return false;
		}
		return true;
	}

	public boolean validateUserIdentity(JobSeekerUser user) throws RemoteException {
		return userIdentityCheckService.checkUserIdentity(user.getNationalIdentity(), user.getFirstName(), user.getLastName(), user.getYearOfBirth());
	}
}
