package com.anti.mrg.roscookservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class ConfigSwagger {

    private val apiInfo: ApiInfo =
            ApiInfoBuilder()
                    .title("Cook api")
                    .contact(ApiInfo.DEFAULT_CONTACT)
                    .build()

    @Bean
    fun swaggerConfig(): Docket =
            Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo)
                    .select()
                    .apis(RequestHandlerSelectors.withClassAnnotation(RestController::class.java))
                    .paths(PathSelectors.any())
                    .build()
}
