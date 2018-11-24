package quizme.demo.entities.questions;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class NonScoredQuestion extends Question {
    private String answer;
}
