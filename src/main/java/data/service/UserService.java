package data.service;

import data.model.user.User;

/**
 * Service that allows retrieval or modification of {@link User} entities
 */
public interface UserService {

    User findByUsername(String username);
}