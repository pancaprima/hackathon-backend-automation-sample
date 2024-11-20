package com.petstore.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pet {
    private Long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private String status;

    @Getter
    @Setter
    public static class Category {
        private Long id;
        private String name;
    }

    @Getter
    @Setter
    public static class Tag {
        private Long id;
        private String name;
    }
}
