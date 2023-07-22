package com.space.account;

import jakarta.inject.Singleton;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing operations related to the Account entity.
 */
@Singleton
public class AccountService {

    private final AccountRepository accountRepository;

    /**
     * Constructs an AccountService with the specified AccountRepository.
     *
     * @param accountRepository the AccountRepository to use for Account operations.
     */
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Saves the specified Account entity to the database.
     *
     * @param account the Account entity to save.
     * @return the saved Account entity.
     */
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    /**
     * Retrieves an Account entity from the database by its ID.
     *
     * @param id the ID of the Account entity to retrieve.
     * @return an Optional containing the retrieved Account entity, or empty if not found.
     */
    public Optional<Account> getById(@NotNull Long id) {
        return accountRepository.findById(id);
    }

    /**
     * Retrieves all Account entities from the database.
     *
     * @return a List of all Account entities.
     */
    public List<Account> listAll() {
        return accountRepository.findAll();
    }

    /**
     * Deletes an Account entity from the database by its ID.
     *
     * @param id the ID of the Account entity to delete.
     */
    public void delete(@NotNull Long id) {
        accountRepository.deleteById(id);
    }
}
