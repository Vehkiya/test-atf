package acceptance.actions;

import data.model.Post;
import data.service.PostService;
import exception.UnexpectedResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.CollectionUtils;

import java.util.Collection;

@Component
public class PostActions {

    @Autowired
    private PostService postService;

    public Post findRandomPost() throws UnexpectedResultException {
        Collection<Post> allPosts = postService.findAll();
        return CollectionUtils.getRandomElement(allPosts)
                .orElseThrow(() -> new UnexpectedResultException("There are no posts"));
    }
}
