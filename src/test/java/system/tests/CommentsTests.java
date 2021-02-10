package system.tests;


import common.configuration.BaseConfiguration;
import data.model.Comment;
import data.model.user.User;
import data.service.CommentService;
import data.service.PostService;
import data.service.UserService;
import org.assertj.core.api.SoftAssertions;
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
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(classes = BaseConfiguration.class)
public class CommentsTests {

    private static final String USER_NAME = "Delphine";
    private static Pattern VALID_EMAIL_PATTERN;
    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @BeforeAll
    static void beforeAll() throws IOException {
        Path path = Paths.get("src/test/resources/validation/valid_email_pattern.txt");
        String patternAsString = new String(Files.readAllBytes(path));
        VALID_EMAIL_PATTERN = Pattern.compile(patternAsString);
    }

    @Test
    void commentsHaveValidEmail() {
        SoftAssertions softAssertions = new SoftAssertions();
        Consumer<Comment> validateComment = c -> softAssertions.assertThat(c.getEmail())
                .withFailMessage("Expected <%s> to have valid email pattern", c.getEmail())
                .matches(VALID_EMAIL_PATTERN);
        User user = userService.findByUsername(USER_NAME);
        assertThat("Valid user is required", user, Matchers.notNullValue());
        postService.findAllForUser(user).stream()
                .flatMap(post -> commentService.findAllForPost(post).stream())
                .forEach(validateComment);
        softAssertions.assertAll();
    }
}
