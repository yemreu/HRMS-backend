package yunusemreuzun.hrms.business.abstracts;

public interface EmailService {

	void send(String sender,String receipent,String subject,String message);
}
