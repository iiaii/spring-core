package com.example.springcore.discount;

import com.example.springcore.member.Grade;
import com.example.springcore.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private static final int DISCOUNT_PERCENT = 10;

    @Override
    public int discount(final Member member, final int price) {
        if (member.isEqualGrade(Grade.VIP)) {
            return price * DISCOUNT_PERCENT / 100;
        }
        return 0;
    }
}
