package quizme.demo.dtos;

import lombok.Data;
import quizme.demo.enums.QuestionCategory;
import quizme.demo.enums.QuestionDifficultyLevel;

import java.time.LocalDateTime;

@Data
public class NonScoredQuestionDtoIn {

    private String questionSentence;
    private LocalDateTime timeConstraint;
    private QuestionCategory questionCategory;
    private QuestionDifficultyLevel questionDifficultyLevel;
    private String answer;
}
