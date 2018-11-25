package quizme.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import quizme.demo.entities.questions.Question;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue
    private Integer id;

    private boolean completed;

    private Integer totalScore;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "quiz_question",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    List<Question> questions;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "event_quiz",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<Event> eventList;
}
