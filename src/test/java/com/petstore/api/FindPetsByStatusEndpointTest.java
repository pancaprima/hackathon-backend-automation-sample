package com.petstore.api;

import com.petstore.api.endpoint.FindPetsByStatusEndpoint;
import com.petstore.api.model.Pet;
import com.petstore.api.service.ApiRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FindPetsByStatusEndpointTest {

    @Test
    public void testFindPetsByStatusWithAvailable() {
        ApiRequest request = new ApiRequest();
        request.setBaseUrl("https://petstore.swagger.io/v2");

        // Adding status query parameter: "available"
        request.addQueryParameter("status", "available");

        FindPetsByStatusEndpoint endpoint = new FindPetsByStatusEndpoint(request);
        List<Pet> response = endpoint.call();

        // Assert that the response is not null
        Assert.assertNotNull(response, "Response should not be null");

        // Assert that the list is not empty
        Assert.assertFalse(response.isEmpty(), "Pets list should not be empty");

        // Verify that each pet has "available" status
        for (Pet pet : response) {
            Assert.assertEquals(pet.getStatus(), "available", "Pet status should be 'available'");
        }
    }

    // Additional tests for other statuses (pending, sold, etc.)
}
