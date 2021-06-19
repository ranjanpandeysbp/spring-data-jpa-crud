package com.asb.example.controller;

import com.asb.example.dto.BookingRequest;
import com.asb.example.dto.BookingResponse;
import com.asb.example.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    public BookingResponse bookTicket(@RequestBody BookingRequest bookingRequest) {
        return bookingService.bookTicket(bookingRequest);
    }

    @GetMapping("/booking/passengerId")
    public BookingResponse getBookingForPassenger(Long passengerId){
        return bookingService.getAllBookings(passengerId);
    }
}
