package com.space.user;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

import javax.validation.Valid;
import java.util.List;

/**
 * HTTP Client interface for performing operations on the User entity.
 * Each method corresponds to an endpoint for creating, reading, and deleting User entities.
 * This client interface can be injected wherever you need to interact with the User REST API.
 */
@Client("/users")
public interface UserClient {

    /**
     * Endpoint to create a new User.
     *
     * @param user the User entity to create.
     * @return the created User entity.
     */
    @Post("/")
    User save(@Body @Valid User user);

    /**
     * Endpoint to retrieve a User by its ID.
     *
     * @param id the ID of the User to retrieve.
     * @return the retrieved User entity.
     */
    @Get("/{id}")
    User getById(Long id);

    /**
     * Endpoint to retrieve all Users.
     *
     * @return a list of all User entities.
     */
    @Get("/")
    List<User> listAll();

    /**
     * Endpoint to delete a User by its ID.
     *
     * @param id the ID of the User to delete.
     */
    @Delete("/{id}")
    void delete(Long id);
}
