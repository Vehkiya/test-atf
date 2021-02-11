package org.example.actions;

import org.example.exception.UnexpectedResultException;
import org.example.model.Comment;
import org.example.model.Post;
import org.example.service.CommentService;
import org.example.util.CollectionUtils;
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
