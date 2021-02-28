package com.hahasber.intellectuals.article;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepo extends JpaRepository<ArticleEntity, UUID> {

    @Query("select a from ArticleEntity as a  join fetch a.tags as t where t.tagText in :tags")
    List<ArticleEntity> findByTags(@Param("tags") Set<String> tags);

    @Query("select a from ArticleEntity as a left join fetch a.tags ")
    List<ArticleEntity> findAllWithTags();

//    @Query("from ArticleEntity where id = :id")
//    List<ArticleEntity> findAllByDate(@Param("id") UUID id);

}
