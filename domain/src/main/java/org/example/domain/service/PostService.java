package org.example.domain.service;

import org.example.domain.model.Post;
import org.example.domain.model.user.User;

import java.util.Collection;

/**
 * Service that allows retrieval or modification of {@link Post} entities
 */
public interface PostService {

    /**
     * Retrieve all posts authored by given {@link User}
     */
    Collection<Post> findAllForUser(User user);

    /**
     * Retrieve all posts
     */
    Collection<Post> findAll();
}
