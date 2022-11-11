package com.company.quiz.dto;

import com.company.quiz.model.AnswerOptions;
import com.company.quiz.model.CorrectAnswer;
import com.company.quiz.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionDto {
    private long id;
    private String description;
    private AnswerOptions answerOptionsSet;
    private CorrectAnswer correctAnswer;
    private User user;
}
