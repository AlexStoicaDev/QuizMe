package quizme.demo.repositories.questions;

import quizme.demo.entities.questions.ScoredQuestion;

import javax.transaction.Transactional;

@Transactional
public interface ScoredQuestionRepository extends QuestionBaseRepository<ScoredQuestion> {
}
