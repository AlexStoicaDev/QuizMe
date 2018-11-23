package quizme.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import quizme.demo.dtos.UserDtoIn;

@Service
@RequiredArgsConstructor
public class ConfirmationService {

    private final MailSender emailSender;

    public void sendRegistrationEmail(UserDtoIn userDtoIn){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(userDtoIn.getEmail());
        simpleMailMessage.setSubject("Welcome");
        simpleMailMessage.setText(getEmailText(userDtoIn));
        emailSender.send(simpleMailMessage);
    }
    private String getEmailText(UserDtoIn userDtoIn){
      return  "Hi "+userDtoIn.getName() +",\nThank you for creating an account\n" ;
    }

}
