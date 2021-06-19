package com.asb.example.repository;

import com.asb.example.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository  extends JpaRepository<PaymentInfo, String> {

    PaymentInfo findByPassengerId(Long passengerId);
}
