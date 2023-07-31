package com.example;

import io.quarkus.test.junit.QuarkusTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@Slf4j
@QuarkusTest
public class UserResourceTest {

    @Test
    public void testCreateUser() {
        given()
                .when().get("/create-user")
                .then()
                .statusCode(200)
                .log();
    }

}
