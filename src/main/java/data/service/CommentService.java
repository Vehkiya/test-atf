package data.service;

import data.model.Comment;
import data.model.Post;

import java.util.Collection;

/**
 * Service that allows retrieval or modification of {@link data.model.Comment} entities
 */
public interface CommentService {

    /**
     * Retrieve all comments for a given {@link Post}
     */
    Collection<Comment> findAllForPost(Post post);
}
