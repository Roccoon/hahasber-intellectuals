package com.hahasber.intellectuals.user;


import com.hahasber.intellectuals.article.ArticleEntity;
import java.util.Date;
import java.util.List;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private Date birthDate;

    @OneToMany(mappedBy="user")
    private List<ArticleEntity> posts;

    protected User() {

    }

    public User(UUID id, String name, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
    }

}