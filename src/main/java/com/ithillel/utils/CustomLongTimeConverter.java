package com.ithillel.utils;

import java.util.Calendar;
import java.util.Objects;
import javax.persistence.AttributeConverter;

public class CustomLongTimeConverter implements AttributeConverter<Long, Calendar> {
    @Override
    public Calendar convertToDatabaseColumn(Long id) {
        if (Objects.isNull(id)) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(id);
        return calendar;
    }

    @Override
    public Long convertToEntityAttribute(Calendar calendar) {
        if (Objects.isNull(calendar)) {
            return null;
        }
        return calendar.getTimeInMillis();
    }
}
