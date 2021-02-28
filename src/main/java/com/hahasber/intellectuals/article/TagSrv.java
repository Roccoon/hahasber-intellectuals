package com.hahasber.intellectuals.article;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class TagSrv {

    private final TagsRepo tagsRepo;

    public TagSrv(TagsRepo tagsRepo) {
        this.tagsRepo = tagsRepo;
    }

    public Set<TagEntity> suggestTags(ArticleEntity entity) {
        List<TagEntity> tags = tagsRepo.findAll();
        String text = entity.getArticleText();
        Set<TagEntity> sugTags = new HashSet<>();
        for (TagEntity tag : tags) {
            if (text.contains(tag.getTagText())) {
                sugTags.add(tag);
            }
        }
        return sugTags;
    }
}
