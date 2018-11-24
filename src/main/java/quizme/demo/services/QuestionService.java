package quizme.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quizme.demo.entities.NonScoredQuestion;
import quizme.demo.entities.Question;
import quizme.demo.repositories.QuestionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public void save(Question question){
        questionRepository.save(question);
    }
    public void delete(Integer id){
        Optional<Question> question= questionRepository.findById(id);
        if(question.isPresent()) {
            questionRepository.delete(question.get());
        }
        else{
            throw new NullPointerException();
        }
    }

    public void update(NonScoredQuestion question, Integer questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        if(optionalQuestion.isPresent()){

            Question oldQuestion = optionalQuestion.get();


            return;
        }
        throw new NullPointerException();
    }
}
