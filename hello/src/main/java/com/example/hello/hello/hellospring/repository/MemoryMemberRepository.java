package com.example.hello.hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static java.util.Map<Long, Member> store = new java.util.HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), memeber);
    }

    @Override
    public java.util.Optional<Member> findById(Long id) {
        return java.util.Optional.ofNullable(store.get(id));
    }
}