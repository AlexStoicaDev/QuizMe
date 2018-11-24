package quizme.demo.repositories.questions;

import quizme.demo.entities.questions.Question;
import quizme.demo.enums.QuestionCategory;
import quizme.demo.enums.QuestionDifficultyLevel;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface QuestionRepository extends  QuestionBaseRepository<Question>{

    List<Question> findAllByQuestionCategory(QuestionCategory questionCategory);
    List<Question> findAllByQuestionDifficultyLevel(QuestionDifficultyLevel questionDifficultyLevel);
}
