package quizme.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quizme.demo.dtos.AnsweredQuestionDtoIn;
import quizme.demo.dtos.QuizDtoIn;
import quizme.demo.dtos.QuizDtoOut;
import quizme.demo.entities.Answer;
import quizme.demo.entities.questions.ScoredQuestion;
import quizme.demo.mappers.QuizMapper;
import quizme.demo.repositories.QuizRepository;
import quizme.demo.repositories.questions.ScoredQuestionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final ScoredQuestionRepository scoredQuestionRepository;

    public QuizDtoOut getQuiz(Integer id) {
        return QuizMapper.toOutBound(quizRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    public Integer getFinalScore(QuizDtoIn quizDtoIn) {
        Integer finalScore = 0;
        for (AnsweredQuestionDtoIn answeredQuestionDtoIn : quizDtoIn.getAnsweredQuestionDtoInList()) {
            finalScore += getQuestionScore(answeredQuestionDtoIn);
        }

        return finalScore;
    }

    private Integer getQuestionScore(AnsweredQuestionDtoIn answeredQuestionDtoIn) {
        List<Answer> userAnswers = answeredQuestionDtoIn.getAnswers();
        ScoredQuestion scoredQuestion = scoredQuestionRepository.findByQuestionSentence(answeredQuestionDtoIn.getSentence()).orElseThrow(() -> new NullPointerException());
        if (compareAnswers(userAnswers, scoredQuestion.getAnswers())) {
            return scoredQuestion.getScore();
        }
        return 0;
    }

    //will not work
    private boolean compareAnswers(List<Answer> userAnswers, List<Answer> actualAnswers) {

        actualAnswers.removeAll(userAnswers);
        return actualAnswers.isEmpty();
    }
}
