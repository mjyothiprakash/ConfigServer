package com.cloudconfigclient.start;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientApplication {
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	@Value("${user.config.url}")
	private String url;
	
	@GetMapping("/users")
	public List<String> getUsersList(){
		return restTemplate.getForObject(url, List.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
}
