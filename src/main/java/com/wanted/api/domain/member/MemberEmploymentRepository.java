package com.wanted.api.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberEmploymentRepository extends JpaRepository<MemberEmployment,Long> {



}
