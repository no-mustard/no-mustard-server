package com.example.hello.hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member memeber);

    java.util.Optional<Member> findById(Long id);

    java.util.Optional<Member> findByName(String name);

    java.util.List<Member> findALl();

}