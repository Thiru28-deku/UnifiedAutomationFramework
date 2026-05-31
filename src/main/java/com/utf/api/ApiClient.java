package com.utf.api;

import java.util.Map;
import com.utf.enums.ConfigProperties;
import com.utf.utils.ConfigUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public final class ApiClient {

    private ApiClient() {
    }

    private static String getBaseUrl() {
        try {
            return ConfigUtils.get(ConfigProperties.APIBASEURL);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load API base URL", e);
        }
    }

    public static Response get(String endpoint) {
        return RestAssured.given()
            .baseUri(getBaseUrl())
            .contentType(ContentType.JSON)
            .when()
            .get(endpoint)
            .then()
            .extract().response();
    }

    public static Response post(String endpoint, Map<String, String> params) {
        return RestAssured.given()
            .baseUri(getBaseUrl())
            .contentType(ContentType.URLENC)
            .formParams(params)
            .when()
            .post(endpoint)
            .then()
            .extract().response();
    }

    public static Response put(String endpoint, Map<String, String> params) {
        return RestAssured.given()
            .baseUri(getBaseUrl())
            .contentType(ContentType.URLENC)
            .formParams(params)
            .when()
            .put(endpoint)
            .then()
            .extract().response();
    }

    public static Response delete(String endpoint, Map<String, String> params) {
        return RestAssured.given()
            .baseUri(getBaseUrl())
            .contentType(ContentType.URLENC)
            .formParams(params)
            .when()
            .delete(endpoint)
            .then()
            .extract().response();
    }
}