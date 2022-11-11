package com.company.quiz.mapper;

import com.company.quiz.dto.QuestionDto;
import com.company.quiz.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    QuestionDto mapQuestionToQuestionDto(Question question);

    Question mapQuestionDtoToQuestion(QuestionDto questionDto);
}
