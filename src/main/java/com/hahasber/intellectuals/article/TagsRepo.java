package com.hahasber.intellectuals.article;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepo extends JpaRepository<TagEntity, UUID> {


}
