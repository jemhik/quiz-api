package com.company.quiz.api;

import com.company.quiz.dto.QuestionDto;
import com.company.quiz.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Quiz management API")
@RequestMapping("/api/v1/quiz")
public interface QuizApi {

    @ApiOperation("Get all questions")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    Page<QuestionDto> getAllQuestions(@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber,
                                      @RequestParam("sortType") String sortType);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Question id")
    })
    @ApiOperation("Get question")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    QuestionDto getQuestion(@PathVariable long id);

    @ApiOperation("Create user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    QuestionDto createQuestion(@RequestBody QuestionDto questionDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Question id")
    })
    @ApiOperation("Update question")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    QuestionDto updateQuestion(@PathVariable long id, @RequestBody QuestionDto questionDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Question id")
    })
    @ApiOperation("Delete question")
    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteQuestion(@PathVariable long id);
}

