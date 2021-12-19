package com.example.springcore.xml;

import com.example.springcore.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {

    @Test
    @DisplayName("xml bean")
    public void xmlAppContext() {
        // given
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

        // when
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        // then
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
