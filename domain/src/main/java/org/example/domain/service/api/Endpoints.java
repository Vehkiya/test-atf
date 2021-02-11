package org.example.domain.service.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
public enum Endpoints {
    GET_USER("/users/{userId}"),
    GET_ALL_USERS("/users"),
    GET_POST("/posts/{postId}"),
    GET_POSTS("/posts"),
    GET_USER_POSTS("/users/{userId}/posts"),
    GET_COMMENT("/comments/{commentId}"),
    GET_COMMENTS("/comments"),
    GET_POST_COMMENTS("/posts/{postId}/comments");

    @Getter
    @Accessors(fluent = true)
    private final String uri;
}
