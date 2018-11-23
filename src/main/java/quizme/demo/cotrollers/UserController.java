package quizme.demo.cotrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import quizme.demo.dtos.UserDtoIn;
import quizme.demo.entities.User;
import quizme.demo.services.UserService;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody UserDtoIn user){
        userService.save(user);
    }


}
