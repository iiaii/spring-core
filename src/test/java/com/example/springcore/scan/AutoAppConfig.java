package com.example.springcore.scan;

import com.example.springcore.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfig {

    @Test
    @DisplayName("basicScan")
    public void basicScan() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        // when
        MemberService memberService = ac.getBean(MemberService.class);

        // then
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
