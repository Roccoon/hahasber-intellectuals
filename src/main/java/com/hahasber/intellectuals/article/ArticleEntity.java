package com.hahasber.intellectuals.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hahasber.intellectuals.user.User;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity(name = "article")
@Data
public class ArticleEntity implements  Cloneable{

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "active_start_time")
    private LocalDateTime activeStartTime;
    @Column(name = "active_end_time")
    private LocalDateTime activeEndTime;
    @Column(name = "article_text")
    private String articleText;
    @Column(name = "author")
    private String author;
    @Column(name = "import_time")
    private LocalDateTime importTime;
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private User user;

    public void deactivate(LocalDateTime time) {
        this.activeEndTime = time;
        this.active = false;
    }

    public void activate(LocalDateTime time) {
        this.activeEndTime = LocalDateTime.MAX;
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