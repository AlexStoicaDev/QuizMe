package quizme.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quizme.demo.dtos.UserDtoIn;
import quizme.demo.mappers.UserMapper;
import quizme.demo.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;

    public void save(UserDtoIn user){


        userRepository.save(UserMapper.toInBound(user));

    }
}
