package com.example.coupon_server.service;

import com.example.coupon_server.producer.CouponCreateProducer;
import com.example.coupon_server.repository.CouponCountRepository;
import com.example.coupon_server.repository.CouponRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplyService {

    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;
    private final CouponCreateProducer couponCreateProducer;

    @Transactional
    public void applyCoupon(Long userId) {
        Long count = couponCountRepository.increment();

        if (count>100) {
            return;
        }

        couponCreateProducer.create(userId);
    }
}
