package yunusemreuzun.hrms.business.concretes.senders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import yunusemreuzun.hrms.business.abstracts.EmailService;
import yunusemreuzun.hrms.business.abstracts.senders.EmailSender;

@Component
public class VerificationEmailSender implements EmailSender{

	@Value("${hrms.noreply.email}")
	private String email;
	
	private EmailService emailService;
	
	@Autowired
	public VerificationEmailSender(EmailService emailService) {
		this.emailService = emailService;
	}

	@Override
	public void send(String receipent,String token) {
		emailService.send(email, receipent, "Doğrulama kodu", token);
	}

}
