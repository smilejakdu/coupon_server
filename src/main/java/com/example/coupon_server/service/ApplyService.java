package com.example.coupon_server.service;

import com.example.coupon_server.domain.Coupon;
import com.example.coupon_server.repository.CouponRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplyService {

    private final CouponRepository couponRepository;

    @Transactional
    public void applyCoupon(Long userId) {
        long count = couponRepository.count();

        if (count>100){
            return;
        }

        couponRepository.save(new Coupon(userId));
    }
}
