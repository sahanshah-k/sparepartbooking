package com.ford.sparepartbooking.service;

import com.ford.sparepartbooking.entity.Booking;
import com.ford.sparepartbooking.model.BookingRequest;

import java.util.List;

public interface BookingService {

    String bookPart(String userId, String itemId, int count);

    List<Booking> bulkBook(List<BookingRequest> bookingList, String username);

    List<Booking> getAllBookings();
}
