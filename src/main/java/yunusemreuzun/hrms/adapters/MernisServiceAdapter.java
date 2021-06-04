package yunusemreuzun.hrms.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Component;

import yunusemreuzun.hrms.business.abstracts.UserIdentityCheckService;

@Component
public class MernisServiceAdapter implements UserIdentityCheckService{

	@Override
	public boolean checkUserIdentity(String nationalIdentity, String firstName, String lastName, String yearOfBirth) throws RemoteException {
		return true;
	}

}
