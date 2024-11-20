package com.petstore.api.service;

import io.restassured.http.ContentType;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ApiRequest {
    private String baseUrl;
    private Map<String, String> queryParams = new HashMap<>();
    private Object requestBody;  // The request body for POST/PUT requests

    public ApiRequest() {}

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void addQueryParameter(String key, String value) {
        this.queryParams.put(key, value);
    }

    public Map<String, String> getQueries() {
        return queryParams;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    // Set the body of the request (for POST, PUT, etc.)
    public void setRequestBody(Object requestBody) {
        this.requestBody = requestBody;
    }

    public Object getRequestBody() {
        return requestBody;
    }
}
