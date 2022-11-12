package com.company.quiz.mapper;

import com.company.quiz.dto.AnswerOptionsDto;
import com.company.quiz.dto.AnswerOptionsDto.AnswerOptionsDtoBuilder;
import com.company.quiz.model.AnswerOptions;
import com.company.quiz.model.AnswerOptions.AnswerOptionsBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-11T13:41:53+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class AnswerOptionsMapperImpl implements AnswerOptionsMapper {

    @Override
    public AnswerOptionsDto mapAnswerOptionsToAnswerOptionsDto(AnswerOptions answerOptions) {
        if ( answerOptions == null ) {
            return null;
        }

        AnswerOptionsDtoBuilder answerOptionsDto = AnswerOptionsDto.builder();

        answerOptionsDto.id( answerOptions.getId() );
        answerOptionsDto.firstOption( answerOptions.getFirstOption() );
        answerOptionsDto.secondOption( answerOptions.getSecondOption() );
        answerOptionsDto.thirdOption( answerOptions.getThirdOption() );
        answerOptionsDto.fourthOption( answerOptions.getFourthOption() );
        answerOptionsDto.question( answerOptions.getQuestion() );

        return answerOptionsDto.build();
    }

    @Override
    public AnswerOptions mapAnswerOptionsDtoToAnswerOptions(AnswerOptionsDto answerOptionsDto) {
        if ( answerOptionsDto == null ) {
            return null;
        }

        AnswerOptionsBuilder answerOptions = AnswerOptions.builder();

        answerOptions.id( answerOptionsDto.getId() );
        answerOptions.firstOption( answerOptionsDto.getFirstOption() );
        answerOptions.secondOption( answerOptionsDto.getSecondOption() );
        answerOptions.thirdOption( answerOptionsDto.getThirdOption() );
        answerOptions.fourthOption( answerOptionsDto.getFourthOption() );
        answerOptions.question( answerOptionsDto.getQuestion() );

        return answerOptions.build();
    }
}
