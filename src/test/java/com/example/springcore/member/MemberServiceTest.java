package com.example.springcore.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    @DisplayName("join")
    public void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // when
        Member findMember = memberService.findMember(1L);

        // then
        assertThat(findMember).isEqualTo(member);
    }

}