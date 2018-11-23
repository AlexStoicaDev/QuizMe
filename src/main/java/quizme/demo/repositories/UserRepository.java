package quizme.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import quizme.demo.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByPhoneNumber(String phoneNumber);
    Optional<User> findByUserKey(String userKey);

}
