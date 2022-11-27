package com.company.quiz.service.impl;

import com.company.quiz.dto.UserDto;
import com.company.quiz.exception.EntityNotFoundException;
import com.company.quiz.exception.UserAlreadyExistsException;
import com.company.quiz.mapper.UserMapper;
import com.company.quiz.model.User;
import com.company.quiz.repository.UserRepository;
import com.company.quiz.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    @Transactional
    public UserDto getUser(long id) {
        log.info("UserService getUser by id " + id);

        User user = userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return UserMapper.INSTANCE.mapUserToUserDto(user);
    }


    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {
        log.info("UserService createUser with id " + userDto.getId());

        if (userRepository.existsById((userDto.getId()))) {
            throw new UserAlreadyExistsException();
        }

        User user = UserMapper.INSTANCE.mapUserDtoToUser(userDto);
        user = userRepository.save(user);

        return UserMapper.INSTANCE.mapUserToUserDto(user);
    }


    @Override
    @Transactional
    public UserDto updateUser(long id, long score) {
        log.info("UserService updateUser with id " + id);

        User oldUser = userRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        oldUser.setScore(score);

        oldUser = userRepository.save(oldUser);

        return UserMapper.INSTANCE.mapUserToUserDto(oldUser);
    }


    @Override
    @Transactional
    public void deleteUser(long id) {
        log.info("UserService deleteUser with id " + id);

        User user = userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        userRepository.delete(user);
    }


    @Override
    @Transactional
    public Page<UserDto> listUsers(Pageable pageable) {
        log.info("UserService listUsers method");
        return userRepository.findAll(pageable)
                .map(UserMapper.INSTANCE::mapUserToUserDto);
    }
}
