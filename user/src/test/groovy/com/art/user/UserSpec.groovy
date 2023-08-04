package com.art.user

import com.art.helpers.TestEntityBuilder
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

/**
 * Tests for the {@link User} entity
 * */

@MicronautTest
class UserSpec extends Specification implements TestEntityBuilder {

    def "can build a user"() {
        expect:
        buildUser(name: "the name").name == "the name"
    }
}
