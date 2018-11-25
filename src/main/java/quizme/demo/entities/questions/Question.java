package quizme.demo.entities.questions;

import lombok.Data;
import quizme.demo.entities.Quiz;
import quizme.demo.enums.QuestionCategory;
import quizme.demo.enums.QuestionDifficultyLevel;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Inheritance
public abstract class Question {


    @Id
    @GeneratedValue
    private Integer id;

    private String questionSentence;
    private LocalDateTime timeConstraint;
    private QuestionCategory questionCategory;
    private QuestionDifficultyLevel questionDifficultyLevel;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "quiz_question",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "quiz_id"))
    private List<Quiz> quizList;
}
