package com.company.quiz.dto;

import com.company.quiz.model.Question;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerOptionsDto {

    private long id;
    private String firstOption;
    private String secondOption;
    private String thirdOption;
    private String fourthOption;
    private Question question;
}
