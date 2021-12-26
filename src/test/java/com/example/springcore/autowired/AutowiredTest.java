package com.example.springcore.autowired;

import com.example.springcore.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    @DisplayName("AutoWiredOption")
    public void autoWiredOption() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

        // when



        // then

    }

    static class TestBean {

        // 메서드 자체가 호출 안됨
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("member1 = " + member);
        }

        // null 출력
        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("member2 = " + member);
        }

        // Optional.empty 출력
        @Autowired
        public void setNoBean3(Optional<Member> member) {
            System.out.println("member3 = " + member);
        }
    }

}
