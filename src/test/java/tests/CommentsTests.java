package tests;


import atf.configuration.TestConfiguration;
import data.model.Comment;
import data.model.user.User;
import data.service.CommentService;
import data.service.PostService;
import data.service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(classes = TestConfiguration.class)
public class CommentsTests {

    private static final String USER_NAME = "Delphine";
    private static String VALID_EMAIL_PATTERN = "";
    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @BeforeAll
    static void beforeAll() throws IOException {
        Path path = Paths.get("src/test/resources/validation/valid_email_pattern.txt");
        VALID_EMAIL_PATTERN = new String(Files.readAllBytes(path));
    }

    @Test
    void commentsHaveValidEmail() {
        Consumer<Comment> validateComment = c -> assertThat(c.getEmail(), Matchers.matchesPattern(VALID_EMAIL_PATTERN));
        User user = userService.findByUsername(USER_NAME);
        assertThat("Valid user is required", user, Matchers.notNullValue());
        postService.findAllForUser(user).stream()
                .flatMap(post -> commentService.findAllForPost(post).stream())
                .forEach(validateComment);
    }
}
