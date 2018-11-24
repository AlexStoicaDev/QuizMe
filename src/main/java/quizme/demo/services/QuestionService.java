package quizme.demo.services;

import com.google.common.collect.Iterables;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quizme.demo.entities.questions.NonScoredQuestion;
import quizme.demo.entities.questions.Question;
import quizme.demo.entities.questions.ScoredQuestion;
import quizme.demo.enums.QuestionCategory;
import quizme.demo.enums.QuestionDifficultyLevel;
import quizme.demo.repositories.questions.NonScoredQuestionRepository;
import quizme.demo.repositories.questions.QuestionRepository;
import quizme.demo.repositories.questions.ScoredQuestionRepository;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final ScoredQuestionRepository scoredQuestionRepository;
    private final NonScoredQuestionRepository nonScoredQuestionRepository;


    public void save(ScoredQuestion scoredQuestion) {
        scoredQuestionRepository.save(scoredQuestion);
    }


    public void save(NonScoredQuestion nonScoredQuestion) {
        nonScoredQuestionRepository.save(nonScoredQuestion);
    }


    public void delete(Integer questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow(NullPointerException::new);
        questionRepository.delete(question);
    }


    public void update(Integer questionId, String questionSentence, LocalDateTime timeConstraint, QuestionCategory questionCategory,
                       QuestionDifficultyLevel questionDifficultyLevel, Integer score, List<String> answers) {
        ScoredQuestion question = scoredQuestionRepository.findById(questionId).orElseThrow(NullPointerException::new);
        updateBasicQuestion(questionSentence, timeConstraint, questionCategory, questionDifficultyLevel, question);


        if (score != null) {
            question.setScore(score);
        }
        if (answers != null) {
            question.setAnswers(answers);
        }
        scoredQuestionRepository.save(question);
    }

    public void update(Integer questionId, String questionSentence, LocalDateTime timeConstraint, QuestionCategory questionCategory,
                       QuestionDifficultyLevel questionDifficultyLevel, String answer) {
        NonScoredQuestion question = nonScoredQuestionRepository.findById(questionId).orElseThrow(NullPointerException::new);
        updateBasicQuestion(questionSentence, timeConstraint, questionCategory, questionDifficultyLevel, question);
        if (answer != null) {
            question.setAnswer(answer);
        }

        nonScoredQuestionRepository.save(question);

    }

    private void updateBasicQuestion(String questionSentence, LocalDateTime timeConstraint, QuestionCategory questionCategory,
                                     QuestionDifficultyLevel questionDifficultyLevel, Question question) {
        if (questionSentence != null) {
            question.setQuestionSentence(questionSentence);
        }
        if (timeConstraint != null) {
            question.setTimeConstraint(timeConstraint);
        }
        if (questionCategory != null) {
            question.setQuestionCategory(questionCategory);
        }
        if (questionDifficultyLevel != null) {
            question.setQuestionDifficultyLevel(questionDifficultyLevel);
        }
    }


    private ArrayList<Question> sort(Iterable<Question> questions, Comparator<Question> comparator) {
        ArrayList<Question> questions1 = new ArrayList<>();
        questions.forEach(questions1::add);
        questions1.sort(comparator);

        return questions1;
    }

    public List<Question> getSortedQuestionsAscending() {
        return sort(questionRepository.findAll(), Comparator.comparingInt((Question o) -> o.getQuestionDifficultyLevel().ordinal()));
    }
    public List<Question> getSortedQuestinsDescending(){
        List<Question> sortedQuestionsAscending = getSortedQuestionsAscending();
        Collections.reverse(sortedQuestionsAscending);
        return sortedQuestionsAscending;

    }

    public List<Question> filterByCategory(QuestionCategory questionCategory) {
       return questionRepository.findAllByQuestionCategory(questionCategory);
    }

    public List<Question> filterByDiffcultyLevel(QuestionDifficultyLevel questionDifficultyLevel) {
        return questionRepository.findAllByQuestionDifficultyLevel(questionDifficultyLevel);
    }

}
