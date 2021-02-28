package com.hahasber.intellectuals.servey;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(name = "survey_question_results")
public class SurveyQuestionResultsEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id")
    private UUID id;
    @Column(name = "answer")
    private String answer;


    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="id_question")
    private SurveyQuestionsEntity surveyQuestion;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="id_result")
    private SurveyResultEntity surveyResult;

}
