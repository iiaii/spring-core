package com.example.springcore.discount;

import com.example.springcore.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @param member
     * @param price
     * @return 할인 대상 금액
     */
    int discount(final Member member, final int price);
}
