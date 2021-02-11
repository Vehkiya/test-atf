package org.example.domain.service;

import org.example.domain.model.user.User;

/**
 * Service that allows retrieval or modification of {@link User} entities
 */
public interface UserService {

    User findByUsername(String username);
}
