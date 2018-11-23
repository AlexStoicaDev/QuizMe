package quizme.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import quizme.demo.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    User findByPhoneNumber(String phoneNumber);
    User findByUserKey(String userKey);
}
