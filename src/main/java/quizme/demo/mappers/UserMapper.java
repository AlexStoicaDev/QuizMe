package quizme.demo.mappers;

import lombok.experimental.UtilityClass;
import quizme.demo.dtos.UserDtoIn;
import quizme.demo.entities.AppUser;

@UtilityClass
public class UserMapper {

    public AppUser toInBound(UserDtoIn userDtoIn){
        AppUser appUser =new AppUser();
        appUser.setEmail(userDtoIn.getEmail());
        appUser.setName(userDtoIn.getName());
        appUser.setPassword(userDtoIn.getPassword());
        appUser.setPhoneNumber(userDtoIn.getPhoneNumber());

        return appUser;
    }
}
