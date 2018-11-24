package quizme.demo.entities.questions;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import java.util.List;


@Entity
public class ScoredQuestion extends Question {
    private Integer score;

    @Type(type = "string")
    private List<String> answers;
}
