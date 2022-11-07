package com.ford.sparepartbooking.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Builder
@Document(collection = "booking_ford")
public class Booking {

    private String id;

    private String userId;

    private String sparePartId;

    private int sparePartCount;

}
