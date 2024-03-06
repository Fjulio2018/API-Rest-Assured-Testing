package com.cat.bdd.api.stepdefinitions;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Hooks {
    private static RequestSpecification requestSpec;

    @Before
    public static void setupRequestSpec() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.thecatapi.com")
                .setBasePath("/v1/votes")
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", "DEMO-API-KEY")
                .build();
    }

    public static RequestSpecification getRequestSpec() {
        return requestSpec;
    }
}
