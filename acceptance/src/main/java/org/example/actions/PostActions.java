package org.example.actions;

import org.example.exception.UnexpectedResultException;
import org.example.model.Post;
import org.example.service.PostService;
import org.example.util.CollectionUtils;
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
