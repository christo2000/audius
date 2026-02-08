package com.audius.music.config.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Audius Music API",
                version = "1.0",
                description = "APIs for Music CSV processing and tracks"
        )
)
public class SwaggerConfig {
}