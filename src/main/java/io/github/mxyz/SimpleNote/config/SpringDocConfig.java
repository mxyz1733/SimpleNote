package io.github.mxyz.SimpleNote.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 访问 <a href="http://localhost:8080/swagger-ui/index.html#/">swagger-ui</a>以查看接口文档
 */
@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI mangoOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Simple Note API")
                        .version("1.0")
                        .description("Simple Note接口文档"));
    }
}
