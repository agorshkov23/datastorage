package io.github.agorshkov23.datastorage.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("datastorage")
public class DataStorageProperties {
}
