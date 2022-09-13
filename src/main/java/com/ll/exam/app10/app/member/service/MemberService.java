package com.ll.exam.app10.app.member.service;


import com.ll.exam.app10.app.member.entity.Member;
import com.ll.exam.app10.app.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    public void findMember(Long id) {
        memberRepository.findById(id);
    }

    public Member getMemberByUsername(String username) {
        return memberRepository.findByUsername(username).orElse(null);
    }
}
