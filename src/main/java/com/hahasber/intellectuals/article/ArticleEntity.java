package com.hahasber.intellectuals.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "article")
@Getter
@Setter
@NoArgsConstructor
public class ArticleEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    @JsonIgnore
    @Column(name = "active")
    private Boolean active;
    @JsonIgnore
    @Column(name = "active_start_time")
    private LocalDateTime activeStartTime;
    @JsonIgnore
    @Column(name = "active_end_time")
    private LocalDateTime activeEndTime;
    @Column(name = "name")
    private String name;
    @Column(name = "article_text")
    private String articleText;
    @Column(name = "author")
    private String author;
    @JsonIgnore
    @Column(name = "import_time")
    private LocalDateTime importTime;

    @OneToMany(mappedBy="article")
    private Set<TagEntity> tags;

    public void deactivate(LocalDateTime time) {
        this.activeEndTime = time;
        this.active = false;
    }

    public void activate(LocalDateTime time) {
        this.activeEndTime = LocalDateTime.of( LocalDate.of(10000,1,1),LocalTime.of(1,1,1,1));
        this.activeStartTime = time;
        this.active = true;
        this.importTime = time;
    }

    public ArticleEntity clone() {
        ArticleEntity clone = new ArticleEntity();
        clone.setActive(this.active);
        clone.setActiveStartTime(this.activeStartTime);
        clone.setActiveEndTime(this.activeEndTime);
        clone.setArticleText(this.articleText);
        clone.setAuthor(this.author);
        clone.setImportTime(this.importTime);
        return clone;
    }
    @Override
    public String toString() {
        return String.format("Article [id=%s, text=%s]", id, articleText);
    }
}