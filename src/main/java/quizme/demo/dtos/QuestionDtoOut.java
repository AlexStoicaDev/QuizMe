package quizme.demo.dtos;

import lombok.Data;
import quizme.demo.entities.Options;

import java.util.List;

@Data
public class QuestionDtoOut {
    private String sentence;
    private List<Options> options;
}
