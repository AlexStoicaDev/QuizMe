package quizme.demo.entities.questions;

import javax.persistence.Entity;

@Entity
public class NonScoredQuestion extends Question {
    private String answer;
}
