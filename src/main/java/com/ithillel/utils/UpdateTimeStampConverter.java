package com.ithillel.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public class UpdateTimeStampConverter implements AttributeConverter<Timestamp, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(Timestamp timestamp) {
        if (Objects.isNull(timestamp)) {
            timestamp = Timestamp.from(Instant.now());
        }
        return timestamp;
    }

    @Override
    public Timestamp convertToEntityAttribute(Timestamp timestamp) {
        if (Objects.isNull(timestamp)) {
            return null;
        }
        return timestamp;
    }
}
