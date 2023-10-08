package com.wanted.api.domain.employment;

import com.wanted.api.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentRepository extends JpaRepository<Employment,Long>,EmploymentRepositoryCustom {



}
