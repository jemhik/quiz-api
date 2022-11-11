package com.company.quiz.controller;

import com.company.quiz.api.QuizApi;
import com.company.quiz.api.UserApi;
import com.company.quiz.dto.QuestionDto;
import com.company.quiz.dto.UserDto;
import com.company.quiz.service.QuizService;
import com.company.quiz.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class QuizController implements QuizApi {

    private final QuizService quizService;

    @Override
    public Page<QuestionDto> getAllQuestions(int pageSize, int pageNumber, String sortType) {
        log.info("QuizController getAllQuestions method");
        return quizService.listQuestions(PageRequest.of(pageNumber, pageSize, Sort.by(Sort.DEFAULT_DIRECTION, sortType)));
    }

    @Override
    public QuestionDto getQuestion(long id) {
        log.info("QuizController getQuestion with id " + id);
        return quizService.getQuestion(id);
    }

    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {
        log.info("QuizController createQuestion with id " + questionDto.getId());
        return quizService.createQuestion(questionDto);
    }

    @Override
    public QuestionDto updateQuestion(long id, QuestionDto questionDto) {
        log.info("QuizController updateQuestion with id " + id);
        return quizService.updateQuestion(id, questionDto);
    }

    @Override
    public ResponseEntity<Void> deleteQuestion(long id) {
        log.info("QuizController deleteQuestion with id " + id);
        quizService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
}