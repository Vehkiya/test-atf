package data.service.api;

import data.model.Comment;
import data.model.Post;
import data.service.CommentService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Service
public class ApiCommentService implements CommentService {

    @Override
    public Optional<Comment> findById(Long id) {
        Response apiResponse = RestAssured.given()
                .pathParam("commentId", id)
                .when()
                .get(Endpoints.GET_COMMENT.uri())
                .thenReturn();
        return apiResponse.statusCode() == HttpStatus.SC_OK
                ? Optional.of(apiResponse.as(Comment.class))
                : Optional.empty();
    }

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

    @Override
    public Collection<Comment> findAll() {
        return Arrays.asList(RestAssured.when()
                .get(Endpoints.GET_COMMENTS.uri())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .as(Comment[].class));
    }

    @Override
    public Comment add(Comment comment) {
        return RestAssured.given()
                .body(comment)
                .contentType(ContentType.JSON)
                .when()
                .post(Endpoints.GET_COMMENTS.uri())
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .response()
                .as(Comment.class);
    }

    @Override
    public void delete(Comment comment) {
        RestAssured.given()
                .pathParam("commentId", comment.getId())
                .when()
                .delete(Endpoints.GET_COMMENT.uri())
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
