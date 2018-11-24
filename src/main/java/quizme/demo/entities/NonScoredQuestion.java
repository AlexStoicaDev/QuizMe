package quizme.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("Non_scored")
public class NonScoredQuestion extends Question {

    private String answer;
}
