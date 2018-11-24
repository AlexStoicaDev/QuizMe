package quizme.demo.repositories.questions;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import quizme.demo.entities.questions.Question;
import quizme.demo.enums.QuestionCategory;

@NoRepositoryBean
public interface QuestionBaseRepository<T extends Question>  extends CrudRepository<T,Integer> {
    T findByQuestionCategory(QuestionCategory questionCategory);
}
