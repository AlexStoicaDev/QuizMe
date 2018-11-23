package quizme.demo.configurations;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quizme.demo.entities.Role;
import quizme.demo.entities.User;
import quizme.demo.repositories.RoleRepository;
import quizme.demo.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class RemoveThisConfiguration {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Bean
    public void bla(){

        Role admin=new Role();
        admin.setId(1);
        admin.setName("ROLE_ADMIN");

        Role basic=new Role();
        basic.setId(2);
        basic.setName("ROLE_BASIC");

        User user=new User();
        user.setName("admin");
        user.setId(0);
        user.setEmail("alexandrupetrutstoica@gmail.com");
        user.setPassword("admin");
        user.setEnabled(true);
        List<Role> roles=new ArrayList<>();
        List<User> userList=new ArrayList<>();
        userList.add(user);


        roles.add(admin);
        roles.add(basic);
        roleRepository.save(admin);
        roleRepository.save(basic);

        user.setUserRoles(roles);

        userRepository.save(user);
    }

}
