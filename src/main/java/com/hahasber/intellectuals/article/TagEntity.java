package com.hahasber.intellectuals.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "article_tags")
@Getter
@Setter
@NoArgsConstructor
public class TagEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;


    @Column(name = "tag")
    private String tagText;

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_articles")
    private ArticleEntity article;

  }