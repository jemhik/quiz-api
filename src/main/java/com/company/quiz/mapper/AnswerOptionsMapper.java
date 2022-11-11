package com.company.quiz.mapper;

import com.company.quiz.dto.AnswerOptionsDto;
import com.company.quiz.dto.QuestionDto;
import com.company.quiz.model.AnswerOptions;
import com.company.quiz.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerOptionsMapper {
    AnswerOptionsMapper INSTANCE = Mappers.getMapper(AnswerOptionsMapper.class);

    AnswerOptionsDto mapAnswerOptionsToAnswerOptionsDto(AnswerOptions answerOptions);

    AnswerOptions mapAnswerOptionsDtoToAnswerOptions(AnswerOptionsDto answerOptionsDto);
}
