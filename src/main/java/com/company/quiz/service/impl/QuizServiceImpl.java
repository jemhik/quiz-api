package com.company.quiz.service.impl;

import com.company.quiz.dto.QuestionDto;
import com.company.quiz.exception.EntityNotFoundException;
import com.company.quiz.exception.UserAlreadyExistsException;
import com.company.quiz.mapper.QuestionMapper;
import com.company.quiz.mapper.UserMapper;
import com.company.quiz.model.Question;
import com.company.quiz.model.User;
import com.company.quiz.repository.QuestionRepository;
import com.company.quiz.repository.UserRepository;
import com.company.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuestionRepository questionRepository;

    @Override
    public QuestionDto getQuestion(long id) {
        log.info("QuizService getQuestion by id " + id);

        Question question = questionRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return QuestionMapper.INSTANCE.mapQuestionToQuestionDto(question);
    }

    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {
        log.info("QuizService createQuestion with id " + questionDto.getId());

        Question question = QuestionMapper.INSTANCE.mapQuestionDtoToQuestion(questionDto);
        question = questionRepository.save(question);

        return QuestionMapper.INSTANCE.mapQuestionToQuestionDto(question);
    }

    @Override
    public QuestionDto updateQuestion(long id, QuestionDto questionDto) {
        log.info("QuizService updateQuestion with id " + id);

        Question question = QuestionMapper.INSTANCE.mapQuestionDtoToQuestion(questionDto);

        Question oldQuestion = questionRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        question.setId(oldQuestion.getId());
        question = questionRepository.save(question);

        return QuestionMapper.INSTANCE.mapQuestionToQuestionDto(question);
    }

    @Override
    public void deleteQuestion(long id) {
        log.info("QuizService deleteQuestion with id " + id);

        Question question = questionRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        questionRepository.delete(question);
    }

    @Override
    public Page<QuestionDto> listQuestions(Pageable pageable) {
        log.info("QuizService listQuestions method");
        return questionRepository.findAll(pageable)
                .map(QuestionMapper.INSTANCE::mapQuestionToQuestionDto);
    }

}
