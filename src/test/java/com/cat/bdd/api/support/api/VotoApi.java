package com.cat.bdd.api.support.api;

import com.cat.bdd.api.stepdefinitions.Hooks;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;

public class VotoApi {

    JSONObject requestParams = new JSONObject();

    private final String BASE_URI = "https://api.thecatapi.com/v1/";
    private final String API_KEY = "DEMO-API-KEY";


    public VotoApi() {
    }

    public Response realizarBuscaComLimite(int limit) {
        return RestAssured.given()
                .spec(Hooks.getRequestSpec())
                .queryParams("limit", limit)
                .log().all()
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().response();
    }

    public Response realizarBuscaComParametro(int valorparam) {
        String url = "https://api.thecatapi.com/v1/votes/" + valorparam;

        return (Response) RestAssured.given()
                .contentType("application/json")
                .header("x-api-key", "DEMO-API-KEY")
                .log().all()
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().response();
    }


    public Response realizarVoto(JSONObject requestParams) {
        return RestAssured.given()
                .header("x-api-key", API_KEY)
                .contentType("application/json")
                .body(requestParams.toString())
                .log().all()
                .when()
                .post(BASE_URI + "votes")
                .then()
                .extract().response();
    }
}
