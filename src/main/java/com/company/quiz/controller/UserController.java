package com.company.quiz.controller;

import com.company.quiz.api.UserApi;
import com.company.quiz.dto.UserDto;
import com.company.quiz.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public Page<UserDto> getAllUsers(int pageSize, int pageNumber, String sortType) {
        log.info("UserController getAllUsers method");
        return userService
                .listUsers(PageRequest
                        .of(pageNumber, pageSize, Sort
                                .by(Sort.DEFAULT_DIRECTION, sortType).descending()));
    }

    @Override
    public UserDto getUser(long id) {
        log.info("UserController getUser with id " + id);
        return userService.getUser(id);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("UserController getUser with id " + userDto.getId());
        return userService.createUser(userDto);
    }
    @Override
    public UserDto updateUser(long id, long score) {
        log.info("UserController getUser with id " + id);
        return userService.updateUser(id, score);
    }

    @Override
    public ResponseEntity<Void> deleteUser(long id) {
        log.info("UserController getUser with id " + id);
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
