package com.hahasber.intellectuals.servey;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "survey")
public class SurveyEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;

    @OneToMany(mappedBy="survey")
    private List<SurveyQuestionsEntity> questions;

    //    @JsonIgnore
    @OneToMany(mappedBy="survey")
    private List<SurveyResultEntity> results;


}
