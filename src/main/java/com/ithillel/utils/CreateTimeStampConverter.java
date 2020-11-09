package com.ithillel.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

public class CreateTimeStampConverter extends UpdateTimeStampConverter {
    @Override
    public Timestamp convertToDatabaseColumn(Timestamp timestamp) {
        if (Objects.isNull(timestamp)) {
            timestamp = Timestamp.from(Instant.now());
        }
        return timestamp;
    }
}
