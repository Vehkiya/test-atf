package org.example.domain.service.api;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.example.domain.model.user.User;
import org.example.domain.service.UserService;
import org.hamcrest.Matchers;
import org.springframework.stereotype.Service;

@Service
public class UserServiceApiImpl implements UserService {

    @Override
    public User findByUsername(String username) {
        return RestAssured.given()
                .queryParam("username", username)
                .when()
                .get(Endpoints.GET_ALL_USERS.uri())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("size()", Matchers.is(1))
                .and()
                .body("username[0]", Matchers.matchesPattern(username))
                .extract()
                .response()
                .as(User[].class)[0];
    }
}
