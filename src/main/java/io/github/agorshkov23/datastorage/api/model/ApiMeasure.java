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

    /**
     * Идентификатор измерения.
     */
    private Long id;

    /**
     * Идентификатор датчика.
     */
    @NotNull
    private String sensorId;

    /**
     * Дата и время измерения.
     */
    private OffsetDateTime timestamp;

    /**
     * Дата и время регистрации в datastorage.
     */
    private OffsetDateTime dataStorageTimestamp;

    /**
     * Данные.
     */
    private JsonNode data;
}
