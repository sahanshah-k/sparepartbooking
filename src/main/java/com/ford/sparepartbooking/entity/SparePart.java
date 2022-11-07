package com.ford.sparepartbooking.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "spare_part_ford")
public class SparePart {

    @Id
    private String id;

    private String name;

    private int stock;

    private String importCountry;

}
