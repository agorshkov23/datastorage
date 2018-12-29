package io.github.agorshkov23.datastorage.api.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiMeasure {

    private Long id;

    @NotNull
    private String sensorId;

    private OffsetDateTime timestamp;

    private OffsetDateTime dataStorageTimestamp;

    private JsonNode data;
}
