package com.example.springcore.beanfind;

import com.example.springcore.discount.DiscountPolicy;
import com.example.springcore.discount.FixDiscountPolicy;
import com.example.springcore.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘이상 있으면 중복 오류 발생")
    public void findBeanByParentTypeDuplicate() {
        // given

        // when
        Executable executable = () -> {
            ac.getBean(DiscountPolicy.class);
        };

        // then
        assertThrows(NoUniqueBeanDefinitionException.class, executable);
    }

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘이상 있으면 빈 이름 지정")
    public void findBeanByParentTypeBeanName() {
        // given

        // when
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);

        // then
        assertThat(rateDiscountPolicy).isInstanceOf(DiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    public void findBeanBySubType() {
        // given

        // when
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);

        // then
        assertThat(bean).isInstanceOf(DiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회")
    public void findAllBeanByParentType() {
        // given
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);

        // when
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }

        // then
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Object 타입으로 모두 조회")
    public void findAllBeanByObjectType() {
        // given
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);

        // when
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }

        // then

    }

    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }

}
