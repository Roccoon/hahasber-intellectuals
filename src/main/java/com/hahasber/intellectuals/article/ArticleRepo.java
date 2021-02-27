package com.hahasber.intellectuals.article;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepo extends JpaRepository<ArticleEntity, UUID> {

//    @Query("from ArticleEntity where id = :id")
//    List<ArticleEntity> findAllByDate(@Param("id") UUID id);

}
