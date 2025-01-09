package dio.web.api.doc;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {

	private Contact contato() {
		return new Contact("seu nome", "http://www.seusite.com.br", "voce@seusite.com.br");
	}
	
//	private ApiInfoBuilder informacoesApi() {
//		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
//		
//		apiInfoBuilder.title("Title - Rest API");
//		apiInfoBuilder.description("API exemplo de uso de springboot REST API");
//		apiInfoBuilder.version("1.0");
//		apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
//		apiInfoBuilder.license("Licença - Sua empresa");
//		apiInfoBuilder.licenseUrl("http://www.seusite.com.br");
//		apiInfoBuilder.contact(this.contato());
//		
//		return apiInfoBuilder;
//	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Title - Rest API", 
				"API exemplo de uso de springboot REST API", 
				"1.0",
				"Termo de uso: Open Source", 
				this.contato(), 
				"Licença - Sua empresa", 
				"http://www.seusite.com.br",
				Collections.emptyList());
	}
	
	@Bean
	public Docket detalheApi() {
		System.out.println("SwaggerConfig: detalheApi() foi chamado");
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		
		docket
				.select()
				.apis(RequestHandlerSelectors.basePackage("dio.web.api.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(this.apiInfo())
				.consumes(new HashSet<String>(Arrays.asList("application/json")))
				.produces(new HashSet<String>(Arrays.asList("application/json")));
		
		return docket;
		
	}
	
}
