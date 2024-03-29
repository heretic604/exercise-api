package by.heretic.strength_exercise_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static by.heretic.strength_exercise_api.util.Constants.SWAGGER_DESCRIPTION;
import static by.heretic.strength_exercise_api.util.Constants.SWAGGER_SERVER_URL;
import static by.heretic.strength_exercise_api.util.Constants.SWAGGER_TITLE;
import static by.heretic.strength_exercise_api.util.Constants.SWAGGER_VERSION;

@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        Server server = new Server().url(SWAGGER_SERVER_URL);
        return new OpenAPI()
                .info(new Info().title(SWAGGER_TITLE)
                        .description(SWAGGER_DESCRIPTION)
                        .version(SWAGGER_VERSION)
                )
                .servers(List.of(server));
    }

}