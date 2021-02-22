package com.hahasber.intellectuals.dao;

import com.hahasber.intellectuals.entities.ArticleEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepo extends JpaRepository<ArticleEntity, UUID> {

    @Query("from ArticleEntity where id = :id")
    List<ArticleEntity> findAllByDate(@Param("id") UUID id);

}
