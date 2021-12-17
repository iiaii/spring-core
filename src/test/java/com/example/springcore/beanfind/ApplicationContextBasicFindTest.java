package com.example.springcore.beanfind;

import com.example.springcore.AppConfig;
import com.example.springcore.member.MemberService;
import com.example.springcore.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    public void findByBeanName() {
        // given
        String beanName = "memberService";

        // when
        MemberService memberService = ac.getBean(beanName, MemberService.class);

        // then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("타입으로 조회")
    public void findBeanByType() {
        // given

        // when
        MemberService memberService = ac.getBean(MemberService.class);

        // then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름, 구체 타입으로 조회")
    public void findBeanByNameAndType() {
        // given
        String beanName = "memberService";

        // when
        MemberService memberService = ac.getBean(beanName, MemberServiceImpl.class);

        // then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    public void cannotFindBean() {
        // given
        String beanName = "NO";

        // when
        Executable executable = () -> {
            MemberService noBean = ac.getBean(beanName, MemberService.class);
        };

        // then
        assertThrows(NoSuchBeanDefinitionException.class, executable);
    }

}
