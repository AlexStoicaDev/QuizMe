package quizme.demo.repositories.questions;

import quizme.demo.entities.questions.Question;

import javax.transaction.Transactional;

@Transactional
public interface QuestionRepository extends  QuestionBaseRepository<Question>{

}
