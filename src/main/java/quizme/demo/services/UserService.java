package quizme.demo.services;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;
import quizme.demo.dtos.UserDtoIn;
import quizme.demo.entities.User;
import quizme.demo.mappers.UserMapper;
import quizme.demo.repositories.UserRepository;
import quizme.demo.validators.RegistrationValidator;

import javax.mail.MessagingException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ConfirmationService confirmationService;
    private final RegistrationValidator registrationValidator;

    public void save(UserDtoIn userDtoIn) throws MessagingException {

        registrationValidator.validate(userDtoIn);
        User user = UserMapper.toInBound(userDtoIn);
        user.setEnabled(false);
        user.setUserKey(RandomStringUtils.random(8,true,true));
        userRepository.save(user);
        confirmationService.sendRegistrationEmail(user);

    }
}
