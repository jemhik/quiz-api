package com.company.quiz.service;

import com.company.quiz.dto.QuestionDto;
import com.company.quiz.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuizService {

    QuestionDto getQuestion(long id);

    QuestionDto createQuestion(QuestionDto questionDto);

    QuestionDto updateQuestion(long id, QuestionDto questionDto);

    void deleteQuestion(long id);
    Page<QuestionDto> listQuestions(Pageable pageable);

}
