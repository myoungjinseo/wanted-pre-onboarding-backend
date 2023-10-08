package com.wanted.api.domain.employment;

import com.wanted.api.domain.company.Company;
import com.wanted.api.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String position;

    private Long compensation;

    private String content;

    private String skill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "Company_id")
    private Company company;
}
