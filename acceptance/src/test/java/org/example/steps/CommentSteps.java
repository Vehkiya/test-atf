package org.example.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.actions.CommentActions;
import org.example.context.Context;
import org.example.context.Keys;
import org.example.model.Comment;
import org.example.model.Post;
import org.example.service.CommentService;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class CommentSteps {

    @Autowired
    private Context context;
    @Autowired
    private CommentActions commentActions;
    @Autowired
    private CommentService commentService;

    @When("a comment is {word}")
    @When("a new comment is {word}")
    public void aCommentIs(String action) throws Throwable {
        Post post = (Post) context.get(Keys.CURRENT_POST);
        Comment comment;
        switch (action.toLowerCase()) {
            case "add":
            case "added":
                comment = commentService.add(commentActions.generateComment());
                break;
            case "delete":
            case "deleted":
                comment = commentActions.findRandomCommentForPost(post);
                commentService.delete(comment);
                break;
            default:
                throw new Exception("Unknown action");
        }
        context.save(comment, Keys.CURRENT_COMMENT);
    }

    @Then("the comment is {string} in associated post")
    public void theCommentIsInAssociatedPost(String visible) {
        Post post = (Post) context.get(Keys.CURRENT_POST);
        Comment comment = (Comment) context.get(Keys.CURRENT_COMMENT);
        Collection<Comment> allCommentsForPost = commentService.findAllForPost(post);
        switch (visible) {
            case "visible":
                MatcherAssert.assertThat(allCommentsForPost, Matchers.hasItem(comment));
                break;
            case "not visible":
                MatcherAssert.assertThat(allCommentsForPost, Matchers.not(Matchers.hasItem(comment)));
                break;
        }

    }
}
