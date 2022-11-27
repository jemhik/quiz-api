package com.company.quiz.service;

import com.company.quiz.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto getUser(long id);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(long id, long score);

    void deleteUser(long id);

    Page<UserDto> listUsers(Pageable pageable);
}
