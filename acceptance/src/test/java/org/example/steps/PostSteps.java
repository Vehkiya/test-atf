package org.example.steps;

import io.cucumber.java.en.Given;
import org.example.acceptance.actions.PostActions;
import org.example.acceptance.context.Keys;
import org.example.core.context.Context;
import org.example.domain.model.Post;
import org.springframework.beans.factory.annotation.Autowired;

public class PostSteps {

    @Autowired
    private PostActions postActions;
    @Autowired
    private Context context;

    @Given("a random post")
    public void aRandomPost() throws Throwable {
        Post post = postActions.findRandomPost();
        context.save(post, Keys.CURRENT_POST);
    }
}
