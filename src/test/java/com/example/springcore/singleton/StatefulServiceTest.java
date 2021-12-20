package com.example.springcore.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

public class StatefulServiceTest {

    @Test
    @DisplayName("상태를 가지는 싱글톤 테스트")
    public void statefulServiceSingleton() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        // when
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        statefulService1.order("userA", 10000);
        statefulService2.order("userB", 20000);

        // then
        assertThat(statefulService1.getPrice()).isEqualTo(20000);
        assertThat(statefulService2.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

    }

}
