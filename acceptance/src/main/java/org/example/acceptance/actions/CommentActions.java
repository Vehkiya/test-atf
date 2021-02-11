package org.example.acceptance.actions;

import org.example.core.exception.UnexpectedResultException;
import org.example.core.util.CollectionUtils;
import org.example.domain.model.Comment;
import org.example.domain.model.Post;
import org.example.domain.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CommentActions {

    @Autowired
    private CommentService commentService;

    public Comment generateComment() {
        Comment comment = new Comment();
        comment.setName("John Doe");
        comment.setEmail("john.doe@example.com");
        comment.setBody("something about ducks");
        comment.setPostId(81L);
        return comment;
    }

    public Comment findRandomCommentForPost(Post post) throws UnexpectedResultException {
        Collection<Comment> allComments = commentService.findAllForPost(post);
        return CollectionUtils.getRandomElement(allComments)
                .orElseThrow(() -> new UnexpectedResultException("There are no comments"));
    }
}
