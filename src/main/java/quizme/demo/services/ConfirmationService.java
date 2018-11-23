package quizme.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import quizme.demo.entities.User;
import quizme.demo.repositories.UserRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class ConfirmationService {

    private final JavaMailSenderImpl emailSender;
    private final UserRepository userRepository;

    public void sendRegistrationEmail(User user) throws MessagingException {


        MimeMessage mimeMessage=emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(user.getEmail());
        helper.setText(getEmailBody(user), true);
       mimeMessage.setSubject("Welcome");



        //simpleMailMessage.setTo(user.getEmail());
       // simpleMailMessage.setSubject("Welcome");
        emailSender.send(mimeMessage);
    }

    public void confirmRegistration(String userKey){
        User user = userRepository.findByUserKey(userKey);
        if(user==null){
            throw new NullPointerException();
        }
        user.setUserKey(null);
        user.setEnabled(true);
        userRepository.save(user);
    }

    private String getEmailBody(User user){

        return "<html>" +
                "<head><title>"+"Welcome"+"</title></head>" +
                "<body>" +
                "<h1>Thank you for creating an account</h1>"+
                "Click <a href=\"" + "http://localhost:8090/api/confirmation/"+user.getUserKey()+"\""+
                ">here</a> to activate your account." +
                "</body>" +
                "</html>";
      /*String text=  "Hi "+user.getName() +",\nThank you for creating an account\n" ;
      text+="Please confirm your registration:\n";
      Hyperlink hyperlink=new Hyperlink("localhost:8090/api/confirmation/"+user.getUserKey());
      text+=hyperlink;*/



    }

}
