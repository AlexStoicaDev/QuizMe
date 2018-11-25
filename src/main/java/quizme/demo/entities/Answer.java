package quizme.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import quizme.demo.entities.questions.Question;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue
    private Integer id;

    private String answer;

    @ManyToOne
    @JsonIgnore
    private Question question;
}
