package quizme.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("Scored")
public class ScoredQuestion extends Question {

    private Integer score;

    @Type(type = "string")
    private List<String> answers;
}
