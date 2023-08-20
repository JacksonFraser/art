package com.art.user;

import jakarta.inject.Singleton;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

/**
 * Service class for handling operations related to the User entity.
 */
@Singleton
public class UserService {

    private final UserRepository userRepository;

    /**
     * Constructs a UserService with the specified UserRepository.
     *
     * @param userRepository the UserRepository to use for User operations.
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Saves the specified User entity to the database.
     *
     * @param user the User entity to save.
     * @return the saved User entity.
     */
    public User save(User user) {
        return userRepository.save(user);
    }

    /**
     * Retrieves a User entity from the database by its ID.
     *
     * @param id the ID of the User entity to retrieve.
     * @return an Optional containing the retrieved User entity, or empty if not found.
     */
    public Optional<User> getById(@NotNull Long id) {
        return userRepository.findById(id);
    }

    /**
     * Retrieves all User entities from the database.
     *
     * @return a List of all User entities.
     */
    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }

    /**
     * Deletes a User entity from the database by its ID.
     *
     * @param id the ID of the User entity to delete.
     */
    public void delete(@NotNull Long id) {
        userRepository.deleteById(id);
    }
}
