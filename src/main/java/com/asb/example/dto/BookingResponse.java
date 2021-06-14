package com.asb.example.dto;

import com.asb.example.entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {

    private String status;
    private double totalFare;
    private String pnr;
    private PassengerInfo passengerInfo;
}
