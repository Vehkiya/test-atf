package org.example.service;

import org.example.model.Post;
import org.example.model.user.User;

import java.util.Collection;

/**
 * Service that allows retrieval or modification of {@link org.example.model.Post} entities
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
