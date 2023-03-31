package com.example.hello.hello.hellospring.repository;

import com.example.hello.hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static java.util.Map<Long, Member> store = new java.util.HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public java.util.Optional<Member> findById(Long id) {
        return java.util.Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }
    public void clearStore() {
        store.clear();
    }
}