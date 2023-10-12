package com.wanted.api.domain.employment.repo;

import com.wanted.api.domain.employment.entity.Employment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentRepository extends JpaRepository<Employment,Long>,EmploymentRepositoryCustom {



}
