package com.example.demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	//	************this will be replaced by one line in application.properties !
	//	//reading properties and customizing them according to the accept header
	//	@Bean
	//	public ResourceBundleMessageSource messageSource() {
	//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	//		//messages+something for language file names 
	//		messageSource.setBasename("messages");
	//		return messageSource;
	//	}
}
