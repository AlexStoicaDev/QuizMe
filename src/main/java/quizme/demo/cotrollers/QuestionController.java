package quizme.demo.cotrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import quizme.demo.entities.questions.NonScoredQuestion;
import quizme.demo.entities.questions.ScoredQuestion;
import quizme.demo.repositories.questions.NonScoredQuestionRepository;
import quizme.demo.repositories.questions.ScoredQuestionRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/question")
@PreAuthorize("hasAuthority('ADMIN')")
public class QuestionController {

    private final ScoredQuestionRepository scoredQuestionRepository;
    private final NonScoredQuestionRepository nonScoredQuestionRepository;

    @PostMapping("/scored")
    @ResponseStatus(HttpStatus.CREATED)
    public void createScoredQuestion(@RequestBody ScoredQuestion scoredQuestion){
        scoredQuestionRepository.save(scoredQuestion);
    }

    @PostMapping("/non-scored")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNonScoredQuestion(@RequestBody NonScoredQuestion nonScoredQuestion){
        nonScoredQuestionRepository.save(nonScoredQuestion);
    }

}
