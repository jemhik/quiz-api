package com.company.quiz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String academicGroup;
    private long score;
}
