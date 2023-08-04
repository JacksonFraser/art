package com.space.helpers

import com.space.account.Account
import com.space.account.AccountRepository
import com.space.user.User
import com.space.user.UserRepository
import io.micronaut.context.ApplicationContext
import jakarta.inject.Inject
import spock.lang.Shared

trait TestEntityBuilder {

    @Shared
    @Inject
    ApplicationContext context


    User buildUser(Map givenValues = [:]) {

        Map values = [
                name: "Bobby Jarzombek"
        ] + (givenValues ?: [:])

        User user = User.builder()
                .name(values.name)
                .build()
        Account account = Account.builder()
                .accountName("a1")
                .accountType("at1")
                .build()

        user.setAccount(account)
        account.setUser(user)

        return context.getBean(UserRepository).with {
            return save(user)
        }
    }

    Account buildAccount(Map givenValues = [:]) {

        Map values = [
                accountName: "the account",
                accountType: "the account type",

        ] + (givenValues ?: [:])

        Account account = buildEntity(Account, values)

        account.setUser(User.builder()
                .name("u1")
                .account(account)
                .build())
        return context.getBean(AccountRepository).with {
            return findByAccountName(account.accountName).orElseGet({
                return save(account)
            })
        }
    }
}