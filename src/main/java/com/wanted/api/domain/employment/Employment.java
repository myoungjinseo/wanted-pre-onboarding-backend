package com.wanted.api.domain.employment;

import com.wanted.api.domain.company.Company;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
