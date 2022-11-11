package com.company.quiz.dto;

import com.company.quiz.model.Question;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CorrectAnswerDto {

    private long id;
    private String answerOption;
    private Question question;
}
