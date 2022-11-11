package com.company.quiz.mapper;

import com.company.quiz.dto.CorrectAnswerDto;
import com.company.quiz.dto.UserDto;
import com.company.quiz.model.CorrectAnswer;
import com.company.quiz.model.User;
import org.mapstruct.factory.Mappers;

public interface CorrectAnswerMapper {
    CorrectAnswerMapper INSTANCE = Mappers.getMapper(CorrectAnswerMapper.class);

    CorrectAnswerDto mapCorrectAnswerToCorrectAnswerDto(CorrectAnswer correctAnswer);

    CorrectAnswer mapCorrectAnswerDtoToCorrectAnswer(CorrectAnswerDto correctAnswerDto);
}
