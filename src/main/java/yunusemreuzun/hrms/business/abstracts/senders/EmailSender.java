package yunusemreuzun.hrms.business.abstracts.senders;

public interface EmailSender extends Sender{

	void send(String receipent,String token);
}
