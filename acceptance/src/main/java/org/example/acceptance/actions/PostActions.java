package org.example.acceptance.actions;

import org.example.core.exception.UnexpectedResultException;
import org.example.core.util.CollectionUtils;
import org.example.domain.model.Post;
import org.example.domain.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class PostActions {

    @Autowired
    private PostService postService;

    public Post findRandomPost() throws UnexpectedResultException {
        Collection<Post> allPosts = postService.findAll();
        return CollectionUtils.getRandomElement(allPosts)
                .orElseThrow(() -> new UnexpectedResultException("There are no posts"));
    }
}
