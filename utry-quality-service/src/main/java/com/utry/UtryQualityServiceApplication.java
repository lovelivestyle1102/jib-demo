package com.utry;

import io.micrometer.core.instrument.MeterRegistry;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@MapperScan("com.utry.mapper")
@SpringBootApplication public class UtryQualityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtryQualityServiceApplication.class, args);
    }

    @Bean MeterRegistryCustomizer meterRegistryCustomizer(MeterRegistry meterRegistry) {
        return meterRegistry1 -> {
            meterRegistry.config()
                .commonTags("application", "utry-quality-service");
        };
    }

}
