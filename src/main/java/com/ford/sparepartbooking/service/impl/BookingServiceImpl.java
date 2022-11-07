package com.ford.sparepartbooking.service.impl;

import com.ford.sparepartbooking.entity.Booking;
import com.ford.sparepartbooking.exception.NoSparePartException;
import com.ford.sparepartbooking.model.BookingRequest;
import com.ford.sparepartbooking.repository.BookingRepository;
import com.ford.sparepartbooking.repository.SparePartRepository;
import com.ford.sparepartbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SparePartRepository sparePartRepository;

    @Override
    public String bookPart(String userId, String itemId, int count) {

        sparePartRepository.findById(itemId)
                .filter(sparePart -> sparePart.getStock() > 0)
                .orElseThrow(() -> new NoSparePartException("Either the Spare Part is not found or out of stock"));

        String id = UUID.randomUUID().toString();
        bookingRepository.save(
                Booking.builder()
                        .id(id)
                        .sparePartCount(count)
                        .sparePartId(itemId)
                        .userId(userId)
                        .build()
        );
        return id;
    }

    @Override
    public List<Booking> bulkBook(List<BookingRequest> bookingList, String username) {
        List<Booking> bookings = new ArrayList<>();

        if (bookingList.stream()
                .anyMatch(bookingRequest -> sparePartRepository.findById(bookingRequest.getSparePartId())
                        .filter(sparePart -> sparePart.getStock() <= 0)
                        .isPresent())) {
            throw new NoSparePartException("No Spare Part");
        }

        for (BookingRequest booking : bookingList) {
            String id = UUID.randomUUID().toString();
            bookings.add(Booking.builder()
                    .id(id)
                    .userId(username)
                    .sparePartCount(booking.getSparePartCount())
                    .sparePartId(booking.getSparePartId())
                    .build());
        }
        bookingRepository.saveAll(bookings);
        return bookings;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

}
