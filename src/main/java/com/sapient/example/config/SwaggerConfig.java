package com.sapient.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.sapient.example.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(createApiInfo());
	}

	private ApiInfo createApiInfo() {
		return new ApiInfoBuilder().title("Football league service API. ")
				.description("\"A service to find standings of a team playing league football match using country name, league name and team name. \"")
				.contact(new springfox.documentation.service.Contact("Sunil Sharma", "", "sunil.sharma7@publicissapient.com"))
				.version("1.0.0").build();
	}

	@Controller
	public class HomeController {

		@RequestMapping(value = "/")
		public String index() {
			return "/league/api";
		}
		
		@RequestMapping("/league/api")
		public String home() {
			return "redirect:/swagger-ui.html";
		}
	}
}
