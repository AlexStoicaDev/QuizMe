package quizme.demo.dtos;

import lombok.Data;

import java.util.List;

@Data
public class QuizDtoIn {
    private List<AnsweredQuestionDtoIn> answeredQuestionDtoInList;
}
