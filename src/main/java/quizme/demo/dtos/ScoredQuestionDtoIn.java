package quizme.demo.dtos;

import lombok.Data;
import quizme.demo.entities.Answer;
import quizme.demo.entities.Options;
import quizme.demo.enums.QuestionCategory;
import quizme.demo.enums.QuestionDifficultyLevel;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
public class ScoredQuestionDtoIn {
    private String questionSentence;
    private LocalDateTime timeConstraint;
    private QuestionCategory questionCategory;
    private QuestionDifficultyLevel questionDifficultyLevel;
    private Integer score;
    private ArrayList<Answer> answers;
    private ArrayList<Options> options;
}
