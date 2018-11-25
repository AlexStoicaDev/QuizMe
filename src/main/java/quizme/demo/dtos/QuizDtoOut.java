package quizme.demo.dtos;

import lombok.Data;

import java.util.List;

@Data
public class QuizDtoOut {
    private List<QuestionDtoOut> questionDtoOutList;
}
