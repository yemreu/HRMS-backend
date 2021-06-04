package yunusemreuzun.hrms.business.abstracts;

import java.rmi.RemoteException;

public interface UserIdentityCheckService {

	boolean checkUserIdentity(String nationalIdentity, String firstName, String lastName, String yearOfBirth) throws RemoteException;
}
