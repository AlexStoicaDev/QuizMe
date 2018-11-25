package quizme.demo.dtos;

import lombok.Data;
import quizme.demo.entities.Answer;

import java.util.List;

@Data
public class AnsweredQuestionDtoIn {
    private String sentence;
    List<Answer> answers;
}
