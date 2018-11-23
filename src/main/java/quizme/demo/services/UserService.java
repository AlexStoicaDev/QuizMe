package quizme.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quizme.demo.dtos.UserDtoIn;
import quizme.demo.mappers.UserMapper;
import quizme.demo.repositories.UserRepository;
import quizme.demo.validators.RegistrationValidator;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ConfirmationService confirmationService;
    private final RegistrationValidator registrationValidator;

    public void save(UserDtoIn user){

        registrationValidator.validate(user);
        userRepository.save(UserMapper.toInBound(user));
        confirmationService.sendRegistrationEmail(user);

    }
}
