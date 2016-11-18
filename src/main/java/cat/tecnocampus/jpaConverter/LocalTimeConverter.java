package cat.tecnocampus.jpaConverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by roure on 16/11/2016.
 */

@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time> {

    @Override
    public java.sql.Time convertToDatabaseColumn(java.time.LocalTime attribute) {

        return attribute == null ? null : java.sql.Time.valueOf(attribute);
    }

    @Override
    public java.time.LocalTime convertToEntityAttribute(java.sql.Time dbData) {

        return dbData == null ? null : dbData.toLocalTime();
    }
}
