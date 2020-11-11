package com.ithillel.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

public class CreateTimeStampConverter extends UpdateTimeStampConverter {
    @Override
    public Timestamp convertToDatabaseColumn(Long longTime) {
        if (Objects.isNull(longTime)) {
            longTime = Timestamp.from(Instant.now()).getTime();
        }
        return Timestamp.from(Instant.ofEpochMilli(longTime));
    }
}
