package io.github.agorshkov23.datastorage.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("datastorage")
public class DataStorageProperties {

    private Service service = new Service();

    @Data
    public static class Service {
        private ServiceProperties measure = new ServiceProperties().maxPageSize(15);
    }

    @Data
    @Accessors(fluent = true)
    public static class ServiceProperties {

        private boolean active = false;

        private int maxPageSize = -1;

        public int fixPageSize(int size) {
            return Math.min(maxPageSize, size);
        }
    }
}
