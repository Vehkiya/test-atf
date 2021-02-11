package org.example.service;

import org.example.model.user.User;

/**
 * Service that allows retrieval or modification of {@link User} entities
 */
public interface UserService {

    User findByUsername(String username);
}
