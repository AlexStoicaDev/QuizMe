package quizme.demo.entities.questions;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@Entity
@NoArgsConstructor
public class ScoredQuestion extends Question {
    private Integer score;


}
