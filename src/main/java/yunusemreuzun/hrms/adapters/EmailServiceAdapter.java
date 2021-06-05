package yunusemreuzun.hrms.adapters;


import org.springframework.stereotype.Component;

import yunusemreuzun.hrms.business.abstracts.EmailService;

@Component
public class EmailServiceAdapter implements EmailService{

	public void send(String sender, String receipent,String subject,String message) {
		System.out.println("E-mail gönderildi.\nGönderici: " + sender + "\nAlıcı: " + receipent + " \nKonu: " + subject + "\nMesaj : " + message);
	}
}
