package demo.sbsolutionsnepal.yoapp.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static demo.sbsolutionsnepal.yoapp.base.apiUrl.Url.*;

/**
 * @author Himal Rai on 2/19/2022
 * SB Solutions Pvt.Ltd
 */
@Configuration
@EnableSwagger2
public class WebConfig {

// start --   Configure Swagger-Ui

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build().apiInfo(metaData());
    }

    private ApiInfo metaData(){
        return new ApiInfoBuilder()
                .title("Sb Solutions - POC APIS ")
                .description("POC for yo-app merchant tracker")
                .version("0.0.1")
                .contact(new Contact("Himal Rai",COMPANY_URL,"himal.rai@sbsolutionsnepal.com"))
                .build();
    }

}
