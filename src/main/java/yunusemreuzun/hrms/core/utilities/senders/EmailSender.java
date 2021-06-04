package yunusemreuzun.hrms.core.utilities.senders;

public class EmailSender {
	
	public void send(String sender,String receipent,String subject,String message) {
		System.out.println("E-mail gönderildi.\nGönderici: " + sender + "\nAlıcı: " + receipent + " \nKonu: " + subject + "\nMesaj : " + message);
	}
}
