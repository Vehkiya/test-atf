package org.example.domain.service;

import org.example.domain.model.Comment;
import org.example.domain.model.Post;

import java.util.Collection;
import java.util.Optional;

/**
 * Service that allows retrieval or modification of {@link Comment} entities
 */
public interface CommentService {

    /**
     * Retrieve comment with specific identifier
     */
    Optional<Comment> findById(Long id);

    /**
     * Retrieve all comments for a given {@link Post}
     */
    Collection<Comment> findAllForPost(Post post);

    /**
     * Retrieve all comments
     */
    Collection<Comment> findAll();

    /**
     * Add a new {@link Comment}
     *
     * @return created comment
     */
    Comment add(Comment comment);

    /**
     * Delete a specific {@link Comment}
     */
    void delete(Comment comment);
}
