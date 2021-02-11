package data.service;

import data.model.Post;
import data.model.user.User;

import java.util.Collection;

/**
 * Service that allows retrieval or modification of {@link data.model.Post} entities
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
