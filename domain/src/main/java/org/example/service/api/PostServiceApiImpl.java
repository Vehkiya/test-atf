package org.example.service.api;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.example.model.Post;
import org.example.model.user.User;
import org.example.service.PostService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class PostServiceApiImpl implements PostService {

    @Override
    public Collection<Post> findAllForUser(User user) {
        return Arrays.asList(RestAssured.given()
                .pathParam("userId", user.getId())
                .when()
                .get(Endpoints.GET_USER_POSTS.uri())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .as(Post[].class));
    }

    @Override
    public Collection<Post> findAll() {
        return Arrays.asList(RestAssured.when()
                .get(Endpoints.GET_POSTS.uri())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .as(Post[].class));
    }
}
