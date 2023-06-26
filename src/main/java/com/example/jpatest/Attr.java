package com.example.jpatest;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@SuperBuilder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class Attr {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String company;

    private String subject;

    @Column(unique = true)
    private String url;

    private String sector;

    private String startDate;

    private String deadLine;

    private int career; // 년차 신입은 default 0

    private int sectorCode;
}
