package com.company.quiz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstOption;
    private String secondOption;
    private String thirdOption;
    private String fourthOption;

    @OneToOne(mappedBy = "answerOptionsSet")
    @JsonIgnore
    private Question question;
}
