package quizme.demo.entities.questions;

import quizme.demo.enums.QuestionCategory;
import quizme.demo.enums.QuestionDifficultyLevel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import java.time.LocalDateTime;

@Entity
@Inheritance
public abstract class Question {


    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime timeConstraint;
    private QuestionCategory questionCategory;
    private QuestionDifficultyLevel questionDifficultyLevel;
}
