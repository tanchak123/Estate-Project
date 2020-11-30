package com.ithillel.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;
import javax.persistence.AttributeConverter;

public class UpdateTimeStampConverter implements AttributeConverter<Long, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(Long timestamp) {
        if (Objects.isNull(timestamp)) {
            return Timestamp.from(Instant.now());
        }
        return Timestamp.from(Instant.now());
    }

    @Override
    public Long convertToEntityAttribute(Timestamp timestamp) {
        if (Objects.isNull(timestamp)) {
            return Timestamp.from(Instant.now()).getTime();
        }
        return timestamp.getTime();
    }
}
