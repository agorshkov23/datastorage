package io.github.agorshkov23.datastorage.mapper;

import io.github.agorshkov23.datastorage.api.model.ApiMeasure;
import io.github.agorshkov23.datastorage.domain.Measure;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class MeasureMapper {

    public ApiMeasure toApiMeasure(Measure source) {
        if (source == null) return null;
        return ApiMeasure.builder()
                .id(source.getId())
                .sensorId(source.getSensorId())
                .timestamp(source.getTimestamp().atOffset(ZoneOffset.UTC))
                .dataStorageTimestamp(source.getTimestamp().atOffset(ZoneOffset.UTC))
                .data(source.getData())
                .build();
    }

    public Measure toMeasure(ApiMeasure source) {
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
        if (source == null) return null;
        return Measure.builder()
                .sensorId(source.getSensorId())
                .timestamp(source.getTimestamp() == null
                        ? now
                        : source.getTimestamp().toLocalDateTime())
                .dataStorageTimestamp(now)
                .data(source.getData())
                .build();
    }
}
