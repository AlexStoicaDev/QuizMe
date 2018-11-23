package quizme.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import quizme.demo.repositories.RoleRepository;
import quizme.demo.repositories.UserRepository;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }
}
