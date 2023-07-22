package com.space.account;

import io.micronaut.http.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Controller class for managing operations related to the Account entity.
 */
@Controller("/accounts")
public class AccountController {

    private final AccountService accountService;

    /**
     * Constructs an AccountController with the specified AccountService.
     *
     * @param accountService the AccountService to use for Account operations.
     */
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Endpoint to create a new Account.
     *
     * @param account the Account entity to create.
     * @return the created Account entity.
     */
    @Post("/")
    public Account save(@Body @Valid Account account) {
        return accountService.save(account);
    }

    /**
     * Endpoint to retrieve an Account by its ID.
     *
     * @param id the ID of the Account to retrieve.
     * @return the retrieved Account entity.
     */
    @Get("/{id}")
    public Optional<Account> getById(Long id) {
        return accountService.getById(id);
    }

    /**
     * Endpoint to retrieve all Accounts.
     *
     * @return a list of all Account entities.
     */
    @Get("/")
    public Iterable<Account> listAll() {
        return accountService.listAll();
    }

    /**
     * Endpoint to delete an Account by its ID.
     *
     * @param id the ID of the Account to delete.
     */
    @Delete("/{id}")
    public void delete(Long id) {
        accountService.delete(id);
    }
}
