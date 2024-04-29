package com.bosch.spring.microservices.limitsservice.controller;

import com.bosch.spring.microservices.limitsservice.bean.LimitConfiguration;
import com.bosch.spring.microservices.limitsservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
    private Configuration configuration;

    @Autowired
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfigurations() {
         return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }
}