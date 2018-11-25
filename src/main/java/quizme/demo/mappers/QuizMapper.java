package quizme.demo.mappers;

import lombok.experimental.UtilityClass;
import quizme.demo.dtos.QuizDtoOut;
import quizme.demo.entities.Quiz;
import quizme.demo.entities.questions.Question;
import quizme.demo.entities.questions.ScoredQuestion;

import java.util.stream.Collectors;

@UtilityClass
public class QuizMapper {
    public QuizDtoOut toOutBound(Quiz quiz) {
        QuizDtoOut quizDtoOut = new QuizDtoOut();
        quizDtoOut.setQuestionDtoOutList(
                quiz.getQuestions().parallelStream().map((Question question) -> QuestionMapper.toOutBound((ScoredQuestion) question))
        .collect(Collectors.toList()));

        return quizDtoOut;
    }
}

