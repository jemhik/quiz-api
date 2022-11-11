package com.company.quiz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;

    @OneToOne
    @JoinColumn(name = "answer_option_id", referencedColumnName = "id")
    @JsonIgnore
    private AnswerOptions answerOptionsSet;

    @OneToOne
    @JoinColumn(name = "correct_answer_id", referencedColumnName = "id")
    private CorrectAnswer correctAnswer;

}
