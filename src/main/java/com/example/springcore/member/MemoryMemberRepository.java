package com.example.springcore.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private final static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(final Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(final Long memberId) {
        return store.get(memberId);
    }
}
