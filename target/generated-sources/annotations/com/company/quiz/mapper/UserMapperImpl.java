package com.company.quiz.mapper;

import com.company.quiz.dto.UserDto;
import com.company.quiz.dto.UserDto.UserDtoBuilder;
import com.company.quiz.model.User;
import com.company.quiz.model.User.UserBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-11T13:41:53+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto mapUserToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        userDto.id( user.getId() );
        userDto.firstName( user.getFirstName() );
        userDto.lastName( user.getLastName() );
        userDto.academicGroup( user.getAcademicGroup() );
        userDto.score( user.getScore() );

        return userDto.build();
    }

    @Override
    public User mapUserDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.id( userDto.getId() );
        user.firstName( userDto.getFirstName() );
        user.lastName( userDto.getLastName() );
        user.academicGroup( userDto.getAcademicGroup() );
        user.score( userDto.getScore() );

        return user.build();
    }
}
