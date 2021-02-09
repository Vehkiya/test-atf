package data.service;

import data.model.user.User;

import java.util.Optional;

/**
 * Service that allows retrieval or modification of {@link User} entities
 */
public interface UserService {

    Optional<User> findByUsername(String username);
}
