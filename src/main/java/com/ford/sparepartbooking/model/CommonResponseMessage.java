package com.ford.sparepartbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommonResponseMessage {

    private int messageCode;
    private String messageDescription;

}
