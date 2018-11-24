package quizme.demo.repositories.questions;

import quizme.demo.entities.questions.NonScoredQuestion;

import javax.transaction.Transactional;

@Transactional
public interface NonScoredQuestionRepository extends QuestionBaseRepository<NonScoredQuestion>{
}
