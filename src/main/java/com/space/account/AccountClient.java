package com.space.account;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

import javax.validation.Valid;
import java.util.List;

/**
 * HTTP Client interface for performing operations on the Account entity.
 * Each method corresponds to an endpoint for creating, reading, and deleting Account entities.
 * This client interface can be injected wherever you need to interact with the Account REST API.
 */
@Client("/accounts")
public interface AccountClient {

    /**
     * Endpoint to create a new Account.
     *
     * @param account the Account entity to create.
     * @return the created Account entity.
     */
    @Post("/")
    Account save(@Body @Valid Account account);

    /**
     * Endpoint to retrieve an Account by its ID.
     *
     * @param id the ID of the Account to retrieve.
     * @return the retrieved Account entity.
     */
    @Get("/{id}")
    Account getById(Long id);

    /**
     * Endpoint to retrieve all Accounts.
     *
     * @return a list of all Account entities.
     */
    @Get("/")
    List<Account> listAll();

    /**
     * Endpoint to delete an Account by its ID.
     *
     * @param id the ID of the Account to delete.
     */
    @Delete("/{id}")
    void delete(Long id);
}
