package com.petstore.api.endpoint;

import com.petstore.api.model.Pet;
import com.petstore.api.service.ApiRequest;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.List;

public abstract class BaseApiEndPoint<T> {

    protected ApiRequest request;
    private final Class<T> responseClass;

    public BaseApiEndPoint(ApiRequest request, Class<T> responseClass) {
        this.request = request;
        this.responseClass = responseClass;
    }

    public abstract String url();
    public abstract Method httpMethod();
    public abstract int manualEffortInSeconds();

    public T call() {
        String fullUrl = request.getBaseUrl() + url(); // Constructing the full URL

        // Setup RestAssured RequestSpecification
        RequestSpecification requestSpec = RestAssured.given()
                .queryParams(request.getQueries()); // Add query parameters if any

        // Add the request body if it exists (e.g., for POST or PUT requests)
        if (request.getRequestBody() != null) {
            requestSpec.body(request.getRequestBody()).contentType("application/json");
        }

        // Send the actual request using the method and URL
        Response response = requestSpec.request(httpMethod(), fullUrl);

        // Handle the response: check status code, etc.
        if (response.statusCode() == 200) {
            if (responseClass == List.class) {
                // Use TypeRef for List<Pet> deserialization
                return response.body().as((TypeRef<T>) new TypeRef<List<Pet>>() {});
            }
            return response.body().as(responseClass); // For single object deserialization
        } else {
            throw new RuntimeException("API call failed with status code: " + response.statusCode());
        }
    }
}
