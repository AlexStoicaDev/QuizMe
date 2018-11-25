package quizme.demo.cotrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import quizme.demo.dtos.QuizDtoIn;
import quizme.demo.dtos.QuizDtoOut;
import quizme.demo.services.QuizService;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
@CrossOrigin("http://108fb526.ngrok.io")
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public QuizDtoOut getQuiz(@PathVariable("id")Integer id){
        return quizService.getQuiz(id);
    }

    @PostMapping
    @ResponseStatus
    public Integer getFinalScore(@RequestBody QuizDtoIn quizDtoIn){
       return quizService.getFinalScore(quizDtoIn);
    }
}
