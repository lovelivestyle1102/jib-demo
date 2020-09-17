package com.utry.swagger.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * @author: yangchenglong
 * Date: 2020/8/31
 * Time: 1:39 下午
 * Description: 
*/
@OpenAPIDefinition(
    info = @Info(
        title = "质检api接口文档",
        version = "1.0",
        description = "质检系统相关接口"
    ),
    externalDocs = @ExternalDocumentation(description = "参考文档",
        url = "https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations"
    )
)
@Configuration
public class QualitySwaggerConfig {
}
