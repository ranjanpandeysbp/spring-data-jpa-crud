package com.asb.example.service;

import com.asb.example.dto.BookingRequest;
import com.asb.example.dto.BookingResponse;
import com.asb.example.entity.PassengerInfo;
import com.asb.example.entity.PaymentInfo;
import com.asb.example.exception.InsufficientBalanceException;
import com.asb.example.repository.PassengerInfoRepository;
import com.asb.example.repository.PaymentInfoRepository;
import com.asb.example.utility.PaymentGatewaySimulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;
    @Autowired
    private PassengerInfoRepository passengerInfoRepository;

    // Transaction only works with public method and unchecked exception
    @Transactional//(rollbackFor = {InsufficientBalanceException.class}, readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public BookingResponse bookTicket(BookingRequest bookingRequest) {

        BookingResponse bookingResponse = null;
        PassengerInfo passengerInfo = passengerInfoRepository.save(bookingRequest.getPassengerInfo());

        PaymentInfo paymentInfo = bookingRequest.getPaymentInfo();
        // simulate transaction failure due to insufficient balance in account
        PaymentGatewaySimulator.validateFareBalanceCriteria(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setTotalFare(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);

        bookingResponse = new BookingResponse();
        bookingResponse.setStatus("SUCCESS");
        bookingResponse.setPassengerInfo(passengerInfo);
        bookingResponse.setPnr(UUID.randomUUID().toString().split("-")[0]);
        bookingResponse.setTotalFare(passengerInfo.getFare());

        return bookingResponse;
    }
}
