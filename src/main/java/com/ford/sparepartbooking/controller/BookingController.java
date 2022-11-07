package com.ford.sparepartbooking.controller;

import com.ford.sparepartbooking.entity.Booking;
import com.ford.sparepartbooking.exception.NoSparePartException;
import com.ford.sparepartbooking.model.BookingRequest;
import com.ford.sparepartbooking.model.CommonResponseMessage;
import com.ford.sparepartbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("api/")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @RolesAllowed("ROLE_USER")
    @PostMapping("sparePart/book/{itemId}/{count}")
    public ResponseEntity<CommonResponseMessage> bookAPart(@AuthenticationPrincipal User user, @PathVariable("itemId") String itemId, @PathVariable("count") int count) {
        String id = bookingService.bookPart(user.getUsername(), itemId, count);
        return ResponseEntity.ok(new CommonResponseMessage(0, "Booking ID : " + id));
    }

    @RolesAllowed("ROLE_USER")
    @PostMapping("sparePart/bulkBook")
    public List<Booking> bulkBook(@AuthenticationPrincipal User user, @RequestBody List<BookingRequest> bookingList) {
        return bookingService.bulkBook(bookingList, user.getUsername());
    }


    @RolesAllowed("ROLE_ADMIN")
    @GetMapping("sparePart/allBookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @ExceptionHandler({NoSparePartException.class})
    public ResponseEntity<CommonResponseMessage> handleException() {
        return ResponseEntity.ok(new CommonResponseMessage(1, "Either the Spare Part is not found or out of stock"));
    }


}
