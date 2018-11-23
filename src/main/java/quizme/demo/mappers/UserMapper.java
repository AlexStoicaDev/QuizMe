package quizme.demo.mappers;

import lombok.experimental.UtilityClass;
import quizme.demo.dtos.UserDtoIn;
import quizme.demo.entities.User;

@UtilityClass
public class UserMapper {

    public User toInBound(UserDtoIn userDtoIn){
        User user=new User();
        user.setEmail(userDtoIn.getEmail());
        user.setName(userDtoIn.getName());
        user.setPassword(userDtoIn.getPassword());
        user.setPhoneNumber(userDtoIn.getPhoneNumber());

        return user;
    }
}
