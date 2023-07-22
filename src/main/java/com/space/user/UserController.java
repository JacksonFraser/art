package com.space.user;

import io.micronaut.http.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Controller class for managing operations related to the User entity.
 */
@Controller("/users")
public class UserController {

    private final UserService userService;

    /**
     * Constructs a UserController with the specified UserService.
     *
     * @param userService the UserService to use for User operations.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint to create a new User.
     *
     * @param user the User entity to create.
     * @return the created User entity.
     */
    @Post("/")
    public User save(@Body @Valid User user) {
        return userService.save(user);
    }

    /**
     * Endpoint to retrieve a User by its ID.
     *
     * @param id the ID of the User to retrieve.
     * @return an Optional containing the retrieved User entity, or empty if not found.
     */
    @Get("/{id}")
    public Optional<User> getById(Long id) {
        return userService.getById(id);
    }

    /**
     * Endpoint to retrieve all Users.
     *
     * @return a list of all User entities.
     */
    @Get("/")
    public Iterable<User> listAll() {
        return userService.listAll();
    }

    /**
     * Endpoint to delete a User by its ID.
     *
     * @param id the ID of the User to delete.
     */
    @Delete("/{id}")
    public void delete(Long id) {
        userService.delete(id);
    }
}
