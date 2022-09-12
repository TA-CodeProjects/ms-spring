package com.jb.msserviceb.services;

import com.jb.msserviceb.models.MoneyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class ConvertServiceImpl implements ConvertService {
    private final RestTemplate restTemplate;
    private final RedisTemplate<String, Map<String, Double>> redisTemplate;
    @Value("${cacheLifeTimeHours}")
    private int cacheLifeTime;
    @Value("${convertApi.url}")
    private String url;

    @Override
    public double MoneyConvert(String from, String to, int amount) {
        if (!redisTemplate.hasKey(from)) {
            MoneyResponse response = restTemplate.getForObject(url + "/" + from, MoneyResponse.class);
            if (response == null) {
                throw new RuntimeException("invalid parameters");
            }
            Map<String, Double> rates = response.getRates();
            redisTemplate.opsForValue().set(from, rates, cacheLifeTime, TimeUnit.HOURS);
        }
        double rate = redisTemplate.opsForValue().get(from).get(to);
        return rate * amount;
    }

}


