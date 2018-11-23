package quizme.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import quizme.demo.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
