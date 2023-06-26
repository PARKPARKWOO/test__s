package com.example.jpatest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface Repo extends JpaRepository<Attr, Long> {
        @Query(value = """
            INSERT INTO attr (
                create_date,
                modify_date,
                rel_type_code,
                rel_id,
                type_code,
                type2code,
                value,
                expire_date
            )
            VALUES
            (
                NOW(),
                NOW(),
                :relTypeCode,
                :relId,
                :typeCode,
                :type2Code,
                :value,
                :expireDate
            )
            ON DUPLICATE KEY UPDATE
            modify_date = NOW(),
            `value` = :value,
            expire_date = IFNULL(:expireDate, expire_date) 
            """, nativeQuery = true)
        void upsert(@Param("relTypeCode") String relTypeCode, @Param("relId") long relId, @Param("typeCode") String typeCode, @Param("type2Code") String type2Code, @Param("value") String value, @Param("expireDate") LocalDateTime expireDate);



}
