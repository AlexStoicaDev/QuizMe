package quizme.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import quizme.demo.enums.QuestionCategory;
import quizme.demo.enums.QuestionDifficultyLevel;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    private Integer id;


    private Integer numberOfQuizzes;
    private Integer numberOfQuestionsPerQuiz;
    private QuestionDifficultyLevel questionDifficultyLevel;
    private QuestionCategory questionCategory;


    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "event_quiz",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "quiz_id"))
    private List<Quiz> quizzes;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "event_user",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<AppUser> participants;
}
