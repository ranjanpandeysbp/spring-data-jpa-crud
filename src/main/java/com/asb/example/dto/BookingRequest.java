package com.asb.example.dto;

import com.asb.example.entity.PassengerInfo;
import com.asb.example.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {

    private PaymentInfo paymentInfo;
    private PassengerInfo passengerInfo;
}
