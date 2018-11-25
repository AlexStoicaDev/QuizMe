package quizme.demo.dtos;

import lombok.Data;
import quizme.demo.enums.QuestionCategory;
import quizme.demo.enums.QuestionDifficultyLevel;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ScoredQuestionDtoIn {
    private String questionSentence;
    private LocalDateTime timeConstraint;
    private QuestionCategory questionCategory;
    private QuestionDifficultyLevel questionDifficultyLevel;
    private Integer score;
    private List<String> answers;
    private List<String> options;
}
