package com.petstore.api.endpoint;

import com.petstore.api.service.ApiRequest;
import com.petstore.api.model.Pet;
import io.restassured.http.Method;

import java.util.List;

public class FindPetsByStatusEndpoint extends BaseApiEndPoint<List<Pet>> {

    public FindPetsByStatusEndpoint(ApiRequest request) {
        super(request, (Class<List<Pet>>) (Class<?>) List.class); // Specifies that the response is a list of Pet
    }

    @Override
    public String url() {
        return "/pet/findByStatus"; // API endpoint URL
    }

    @Override
    public Method httpMethod() {
        return Method.GET; // This endpoint uses GET method
    }

    @Override
    public int manualEffortInSeconds() {
        return 5; // Placeholder for manual effort estimate
    }
}
