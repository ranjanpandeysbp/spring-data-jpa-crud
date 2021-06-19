package com.asb.example.service;

import com.asb.example.dto.BookingRequest;
import com.asb.example.dto.BookingResponse;

public interface BookingService {

    public BookingResponse bookTicket(BookingRequest bookingRequest);
    public BookingResponse getAllBookings(Long passengerId);
}
