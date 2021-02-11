package acceptance.steps;

import acceptance.actions.PostActions;
import acceptance.context.Keys;
import common.context.Context;
import data.model.Post;
import io.cucumber.java.en.Given;
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
