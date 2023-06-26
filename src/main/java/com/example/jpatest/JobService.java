package com.example.jpatest;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class JobService {

    private final Repo repo;

    @Transactional
    @Scheduled(cron = "* * * * * *")
    public void set(String varName, String value, LocalDateTime expireDate) {
        String[] varNameBits = varName.split("__");
        String relTypeCode = varNameBits[0];
        long relId = Integer.parseInt(varNameBits[1]);
        String typeCode = varNameBits[2];
        String type2Code = varNameBits[3];

        repo.upsert(relTypeCode, relId, typeCode, type2Code, value, expireDate);
    }
}
