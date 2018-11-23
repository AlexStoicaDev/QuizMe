package quizme.demo.entities;




import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String email;
    private String name;
    private String phoneNumber;
    private Boolean enabled;
    private String userKey;

    @Setter(AccessLevel.NONE)
    private String password;

    public void setPassword(@NotNull String password){
        this.password=new BCryptPasswordEncoder().encode(password);
    }

}
