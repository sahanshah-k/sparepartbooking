package com.ford.sparepartbooking.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {

    private String sparePartId;

    private int sparePartCount;

}
