package com.example.springcore;

import com.example.springcore.member.Grade;
import com.example.springcore.member.Member;
import com.example.springcore.member.MemberService;
import com.example.springcore.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member);
        System.out.println("findMember = " + findMember);
    }
}
