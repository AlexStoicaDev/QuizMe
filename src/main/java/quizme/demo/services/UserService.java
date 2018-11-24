package quizme.demo.services;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;
import quizme.demo.dtos.UserDtoIn;
import quizme.demo.entities.AppUser;
import quizme.demo.entities.Role;
import quizme.demo.mappers.UserMapper;
import quizme.demo.repositories.RoleRepository;
import quizme.demo.repositories.UserRepository;
import quizme.demo.validators.RegistrationValidator;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ConfirmationService confirmationService;
    private final RegistrationValidator registrationValidator;
    private final RoleRepository roleRepository;

    public void save(UserDtoIn userDtoIn) throws MessagingException {

        registrationValidator.validate(userDtoIn);
        AppUser appUser = UserMapper.toInBound(userDtoIn);
        appUser.setEnabled(false);
        appUser.setUserKey(RandomStringUtils.random(8, true, true));
        List<Role> roles = new ArrayList<>();
        roleRepository.findById(2).ifPresent(roles::add);
        appUser.setUserRoles(roles);
        userRepository.save(appUser);
        confirmationService.sendRegistrationEmail(appUser);

    }
}
