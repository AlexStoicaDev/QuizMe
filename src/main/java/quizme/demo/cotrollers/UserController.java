package quizme.demo.cotrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import quizme.demo.dtos.UserDtoIn;
import quizme.demo.services.UserService;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody UserDtoIn user) throws MessagingException {
        userService.save(user);
    }


}
