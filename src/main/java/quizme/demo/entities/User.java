package quizme.demo.entities;




import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> userRoles;

    public void setPassword(@NotNull String password){
        this.password=new BCryptPasswordEncoder().encode(password);
    }

}
