package quizme.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoIn {
    private String email;
    private String name;
    private String phoneNumber;

    private String password;

}
