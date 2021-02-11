package org.example.steps;

import io.cucumber.java.en.Given;
import org.example.actions.PostActions;
import org.example.context.Context;
import org.example.context.Keys;
import org.example.model.Post;
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
