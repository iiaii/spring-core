package com.example.springcore.member;

public interface MemberRepository {

    void save(final Member member);

    Member findById(final Long memberId);

}
