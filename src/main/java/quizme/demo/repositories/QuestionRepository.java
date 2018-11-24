package quizme.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import quizme.demo.entities.Question;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

}
