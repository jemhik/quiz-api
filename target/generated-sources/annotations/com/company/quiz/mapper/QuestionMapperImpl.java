package com.company.quiz.mapper;

import com.company.quiz.dto.QuestionDto;
import com.company.quiz.dto.QuestionDto.QuestionDtoBuilder;
import com.company.quiz.model.Question;
import com.company.quiz.model.Question.QuestionBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-11T13:41:53+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public QuestionDto mapQuestionToQuestionDto(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionDtoBuilder questionDto = QuestionDto.builder();

        questionDto.id( question.getId() );
        questionDto.description( question.getDescription() );
        questionDto.answerOptionsSet( question.getAnswerOptionsSet() );
        questionDto.correctAnswer( question.getCorrectAnswer() );

        return questionDto.build();
    }

    @Override
    public Question mapQuestionDtoToQuestion(QuestionDto questionDto) {
        if ( questionDto == null ) {
            return null;
        }

        QuestionBuilder question = Question.builder();

        question.id( questionDto.getId() );
        question.description( questionDto.getDescription() );
        question.answerOptionsSet( questionDto.getAnswerOptionsSet() );
        question.correctAnswer( questionDto.getCorrectAnswer() );

        return question.build();
    }
}
