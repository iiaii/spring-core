package com.example.springcore.autowired;

import com.example.springcore.AutoAppConfig;
import com.example.springcore.discount.DiscountPolicy;
import com.example.springcore.member.Grade;
import com.example.springcore.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AllBeanTest {

    @Test
    @DisplayName("할인정책 전략패턴으로 제공 테스트")
    public void discountStrategyPattern() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        // when
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int fixDiscountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
        int rateDiscountPrice = discountService.discount(member, 30000, "rateDiscountPolicy");

        // then
        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(fixDiscountPrice).isEqualTo(1000);
        assertThat(rateDiscountPrice).isEqualTo(3000);
    }

    static class DiscountService {

        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        public DiscountService(final Map<String, DiscountPolicy> policyMap, final List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(final Member member, final int price, final String discountCode) {
            return policyMap.get(discountCode)
                    .discount(member, price);
        }
    }


}
