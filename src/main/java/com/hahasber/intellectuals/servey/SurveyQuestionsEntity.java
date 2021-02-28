package com.hahasber.intellectuals.servey;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "survey_questions")
public class SurveyQuestionsEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id")
    private UUID id;
    @Column(name = "questions_number")
    private int questionsNumber;
    @Column(name = "name")
    private String name;
    @Column(name = "questions_text")
    private String questionsText;
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="id_survey")
    private SurveyEntity survey;

    @OneToMany(mappedBy="surveyQuestion")
    private List<SurveyQuestionResultsEntity> surveyQuestionResults;

}
