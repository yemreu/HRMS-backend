package yunusemreuzun.hrms.business.concretes.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import yunusemreuzun.hrms.business.abstracts.validators.UserValidator;
import yunusemreuzun.hrms.entities.concretes.EmployerUser;

@Component
public class EmployerUserValidator implements UserValidator{

	public boolean validateIfFieldsNotEmpty(EmployerUser user) {
		if (ObjectUtils.isEmpty(user.getEmail()) || ObjectUtils.isEmpty(user.getPassword())
				|| ObjectUtils.isEmpty(user.getCompanyName()) || ObjectUtils.isEmpty(user.getWebsite())
				|| ObjectUtils.isEmpty(user.getPhoneNumber())) {
			return false;
		}
		return true;
	}
	
	public boolean validateIfCompanyEmail(EmployerUser user) {
		String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + Pattern.quote(user.getWebsite().replaceFirst("www.", "")) + "$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmail());
		return matcher.matches();
	}
}
