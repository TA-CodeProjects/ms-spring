package com.jb.msserviceb.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyResponse {
    private String result;
    private String provider;
    private String termsOfUse;
    private int timeLastUpdateUnix;
    private String timeLastUpdateUtc;
    private int timeNextUpdateUnix;
    private String timeNextUpdateUtc;
    private int timeEolUnix;
    @JsonProperty("baseCode")
    private String base;
    private Map<String, Double> rates = new HashMap<>();
}
