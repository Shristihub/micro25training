package com.productapp;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import com.productapp.util.Courses;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogServiceApplication.class, args);
	}
	
	@Bean
	ModelMapper mapper() {
		return new ModelMapper();
	}
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	@Profile("default")
	 Courses otherCourse() {
		Courses course = new Courses();
		course.setCourseNames(Arrays.asList("AI","ML"));
		return course;
	}
	@Bean
	@Profile("dev")
	 Courses webCourse() {
		Courses course = new Courses();
		course.setCourseNames(Arrays.asList("React","Angular"));
		return course;
	}
	@Bean
	@Profile("prod")
	 Courses backendCourse() {
		Courses course = new Courses();
		course.setCourseNames(Arrays.asList("Spring","Microservicesr"));
		return course;
	}
	

}
