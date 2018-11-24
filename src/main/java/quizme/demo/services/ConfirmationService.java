package quizme.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import quizme.demo.entities.AppUser;
import quizme.demo.repositories.UserRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class ConfirmationService {

    private final JavaMailSenderImpl emailSender;
    private final UserRepository userRepository;

    public void sendRegistrationEmail(AppUser appUser) throws MessagingException {


        MimeMessage mimeMessage=emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(appUser.getEmail());
        helper.setText(getEmailBody(appUser), true);
       mimeMessage.setSubject("Welcome");
        emailSender.send(mimeMessage);
    }

    public void confirmRegistration(String userKey){
        AppUser appUser = userRepository.findByUserKey(userKey).orElseThrow(NullPointerException::new);
        appUser.setUserKey(null);
        appUser.setEnabled(true);
        userRepository.save(appUser);
    }

    private String getEmailBody(AppUser appUser){

        return "<html>" +
                "<head><title>"+"Welcome"+"</title></head>" +
                "<body>" +
                "<h1>Thank you for creating an account</h1>"+
                "Click <a href=\"" + "http://localhost:8090/api/confirmation/"+ appUser.getUserKey()+"\""+
                ">here</a> to activate your account." +
                "</body>" +
                "</html>";

    }

}
