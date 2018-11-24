package quizme.demo.cotrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import quizme.demo.entities.NonScoredQuestion;
import quizme.demo.entities.Question;
import quizme.demo.entities.ScoredQuestion;
import quizme.demo.repositories.QuestionRepository;
import quizme.demo.services.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class QuestionController {
    private final QuestionService questionService;
    private final QuestionRepository questionRepository;

    @PostMapping("/scored")
    @ResponseStatus(HttpStatus.OK)
    public void addScoredQuestion(@RequestBody ScoredQuestion question) {
        questionService.save(question);
    }

    @PostMapping("/non-scored")
    @ResponseStatus(HttpStatus.OK)
    public void addNonScoredQuestion(@RequestBody NonScoredQuestion question) {
        questionService.save(question);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer questionId){

        questionService.delete(questionId);
    }

    @PutMapping(path="/non-scored/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody NonScoredQuestion question,@PathVariable("id") Integer questionId){
        questionService.update(question,questionId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Question> getAll(){
        return questionRepository.findAll();
    }
}
