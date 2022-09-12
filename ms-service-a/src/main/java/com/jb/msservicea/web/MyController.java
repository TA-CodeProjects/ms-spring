package com.jb.msservicea.web;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MyController {

    @Value("${service.b.url}")
    private String bUrl;
    @Value("${service.b.convertUrl}")
    private String convertUrl;
    private final RestTemplate restTemplate;
    private static final String A_INFO = "aInformation";

//    @RateLimiter(name = A_INFO, fallbackMethod = "fallBackRateLimiter")
//    @Retry(name = A_INFO,fallbackMethod = "fallBackRetry")
    @CircuitBreaker(name = A_INFO, fallbackMethod = "fallBackCircuitBreaker")
    @GetMapping("service/a")
    public Object whoAmI() {
        try {
            String bStr = restTemplate.getForObject(bUrl, String.class);
            return "This is A!!! calling for" + bStr;
        } catch (Exception e) {
            throw e;
        }
    }

    @CircuitBreaker(name = A_INFO, fallbackMethod = "fallBackCircuitBreaker")
    @GetMapping("convert")
    public Object convert(@RequestParam String from, @RequestParam String to, @RequestParam int amount) {
        try {
            return restTemplate.getForObject(convertUrl, Double.class, from, to, amount);
        } catch (Exception e) {
            throw e;
        }
    }

   public Object fallBackCircuitBreaker(Exception e){
        return "This is fallback Circuit Breaker from service a";
   }

    public String fallBackRetry(Exception e){
        return "This is fallback Retry from service a";
    }

    public String fallBackRateLimiter(Exception e){
        return "This is fallback Rate Limiter from service a";
    }
}
