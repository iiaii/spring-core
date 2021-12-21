package com.example.springcore.singleton;

import com.example.springcore.AppConfig;
import com.example.springcore.member.MemberRepository;
import com.example.springcore.member.MemberServiceImpl;
import com.example.springcore.order.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    @DisplayName("configuration test")
    public void configurationTest() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // when
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        // then
        assertThat(memberRepository1).isSameAs(memberRepository2);
        assertThat(memberRepository).isSameAs(memberRepository1);
        assertThat(memberRepository2).isSameAs(memberRepository);
    }
}
