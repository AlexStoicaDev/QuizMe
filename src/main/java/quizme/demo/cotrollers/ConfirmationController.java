package quizme.demo.cotrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import quizme.demo.services.ConfirmationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/confirmation")
@CrossOrigin("http://108fb526.ngrok.io")
public class ConfirmationController {

    private final ConfirmationService confirmationService;

    @GetMapping("/{userKey}")
    @ResponseStatus(HttpStatus.OK)
    public void confirm(@PathVariable String userKey){
        confirmationService.confirmRegistration(userKey);
    }

}
