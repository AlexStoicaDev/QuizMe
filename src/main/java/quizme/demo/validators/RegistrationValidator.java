package quizme.demo.validators;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quizme.demo.dtos.UserDtoIn;
import quizme.demo.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class RegistrationValidator {

    private final UserRepository userRepository;

    public void validate(UserDtoIn userDtoIn) {
        if(userRepository.findByEmail(userDtoIn.getEmail()).isPresent()||
                userRepository.findByPhoneNumber(userDtoIn.getPhoneNumber()).isPresent()){
            throw new NullPointerException();
        }
     /*   if (userRepository.findByEmail(userDtoIn.getEmail()) != null ||
                userRepository.findByPhoneNumber(userDtoIn.getPhoneNumber()) != null) {
            throw new NullPointerException();
        }*/

    }
}
