package quizme.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import quizme.demo.enums.QuestionCategory;
import quizme.demo.enums.QuestionDifficultyLevel;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Question_Type")
public  abstract class Question {
    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime timeConstraint;
    private QuestionCategory questionCategory;
    private QuestionDifficultyLevel questionDifficultyLevel;
}
