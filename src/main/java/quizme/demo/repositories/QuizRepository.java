package quizme.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import quizme.demo.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {

}
