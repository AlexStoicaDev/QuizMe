package quizme.demo.repositories.questions;

import quizme.demo.entities.questions.ScoredQuestion;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface ScoredQuestionRepository extends QuestionBaseRepository<ScoredQuestion> {
    Optional<ScoredQuestion> findByQuestionSentence(String questionSentence);
}
