package com.wanted.api.domain.member;

import com.wanted.api.domain.employment.Employment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Employment_id")
    private Employment employment;
}
