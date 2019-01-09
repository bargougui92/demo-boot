package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import antlr.collections.List;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //making it a config class
@EnableSwagger2
public class SwaggerConfig {
	

	  public static final Contact DEFAULT_CONTACT = new Contact("oussama bargougui",
			  "www.easyweb.com",
			  "oussama.bargougui@easyweb.com");
	 //ctrl+ click on apiInfo to see the arguments meaning
	  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
			  "Awesome Api title",
			  "Awesome Api description",
			  "1.0", 
			  "urn:tos",
	          DEFAULT_CONTACT, 
	          "Apache 2.0", 
	          "http://www.apache.org/licenses/LICENSE-2.0"
	          );
 
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>() {{
	    add("application/json");
	    add("application/xml");
	}};


	//Bean- Docket
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO) //description
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}
	//swagger2
	// All the paths
	// All the apis
}
