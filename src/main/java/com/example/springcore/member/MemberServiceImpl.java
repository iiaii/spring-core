package com.example.springcore.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(final Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(final Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
