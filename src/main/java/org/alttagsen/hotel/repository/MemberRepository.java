package org.alttagsen.hotel.repository;

import org.alttagsen.hotel.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
