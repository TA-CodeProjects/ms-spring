package com.jb.msserviceb.controllers;

import com.jb.msserviceb.services.ConvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ConvertController {
    private final ConvertService convertService;
    @Value("${spring.cloud.consul.discovery.instanceId}")
    private String instId;

    @GetMapping("convert")
    public double convert(@RequestParam String from, @RequestParam String to, @RequestParam int amount) {
        return convertService.MoneyConvert(from, to, amount);
    }

    @GetMapping("service/b")
    public String whoAmI(){
        return "This is "+ instId;
    }

}
