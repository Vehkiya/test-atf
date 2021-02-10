package data.service.api;

import data.model.Comment;
import data.model.Post;
import data.service.CommentService;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class ApiCommentService implements CommentService {

    @Override
    public Collection<Comment> findAllForPost(Post post) {
        return Arrays.asList(RestAssured.given()
                .pathParam("postId", post.getId())
                .when()
                .get(Endpoints.GET_POST_COMMENTS.uri())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .as(Comment[].class));
    }
}
