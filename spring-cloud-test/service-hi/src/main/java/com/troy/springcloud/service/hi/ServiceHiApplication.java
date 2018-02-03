package com.troy.springcloud.service.hi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;

@SpringBootApplication
@RestController
@Slf4j
public class ServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	@Autowired
    private RestTemplate restTemplate;

	@Bean
    public RestTemplate getRestTemplate() {
	    return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String callHome() {
	    log.info("calling trace service-hi");
	    return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }

    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }
}
