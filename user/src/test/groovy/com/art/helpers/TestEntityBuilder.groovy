package com.art.helpers

import com.art.user.User
import com.art.user.UserRepository
import com.art.user.UserType
import io.micronaut.context.ApplicationContext
import jakarta.inject.Inject
import spock.lang.Shared

trait TestEntityBuilder {

    @Shared
    @Inject
    ApplicationContext context

    static <T> T buildEntity(Class<T> clazz, Map properties) {
        T entity = clazz.getDeclaredConstructor().newInstance()
        properties.forEach { key, value -> entity."${key}" = value }
        return entity
    }

    User buildUser(Map givenValues = [:]) {

        Map values = [
                name: "Bobby Jarzombek",
                userType: UserType.PATRON
        ] + givenValues

        User user = User.builder()
                .name(values.name)
                .userType(values.userType)
                .build()

        return context.getBean(UserRepository).with {
            return save(user)
        }
    }

}