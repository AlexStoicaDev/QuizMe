package quizme.demo.cotrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import quizme.demo.dtos.NonScoredQuestionDtoIn;
import quizme.demo.dtos.ScoredQuestionDtoIn;
import quizme.demo.entities.Answer;
import quizme.demo.entities.questions.Question;
import quizme.demo.enums.QuestionCategory;
import quizme.demo.enums.QuestionDifficultyLevel;
import quizme.demo.mappers.QuestionMapper;
import quizme.demo.services.QuestionService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/question")
//@PreAuthorize("hasAuthority('ADMIN')")
@CrossOrigin("http://108fb526.ngrok.io")
public class QuestionController {


    private final QuestionService questionService;

    @PostMapping("/scored")
    @ResponseStatus(HttpStatus.CREATED)
    public void createScoredQuestion(@RequestBody ScoredQuestionDtoIn scoredQuestion) {
        questionService.save(QuestionMapper.toInBound(scoredQuestion));
    }

    @PostMapping("/non-scored")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNonScoredQuestion(@RequestBody NonScoredQuestionDtoIn nonScoredQuestion) {

        questionService.save(QuestionMapper.toInBound(nonScoredQuestion));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuestion(@PathVariable("id") Integer questionId) {
        questionService.delete(questionId);
    }

    @PutMapping("/scored/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Integer questionId, String questionSentence, LocalDateTime timeConstraint, QuestionCategory questionCategory,
                       QuestionDifficultyLevel questionDifficultyLevel, Integer score, ArrayList<Answer> answers) {
        questionService.update(questionId, questionSentence, timeConstraint, questionCategory,
                questionDifficultyLevel, score, answers);

    }

    @PutMapping("/non-scored/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Integer questionId, String questionSentence, LocalDateTime timeConstraint, QuestionCategory questionCategory,
                       QuestionDifficultyLevel questionDifficultyLevel, String answer) {
        questionService.update(questionId, questionSentence, timeConstraint, questionCategory,
                questionDifficultyLevel, answer);

    }

    @GetMapping("/sorted-difficulty-ascending")
    @ResponseStatus(HttpStatus.OK)
    public List<Question> ascending() {
        return questionService.getSortedQuestionsAscending();
    }

    @GetMapping("/sorted-difficulty-descending")
    @ResponseStatus(HttpStatus.OK)
    public List<Question> descending() {
        return questionService.getSortedQuestionsDescending();
    }

    @GetMapping("/filter/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<Question> sortCategory(@PathVariable("category") QuestionCategory questionCategory) {
        return questionService.filterByCategory(questionCategory);
    }

    @GetMapping("/filter/difficulty/{difficulty}")
    @ResponseStatus(HttpStatus.OK)
    public List<Question> sortDifficulty(@PathVariable("difficulty") QuestionDifficultyLevel questionDifficultyLevel) {
        return questionService.filterByDiffcultyLevel(questionDifficultyLevel);
    }


}

