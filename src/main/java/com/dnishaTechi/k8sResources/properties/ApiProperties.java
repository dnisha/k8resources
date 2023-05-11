package com.dnishaTechi.k8sResources.properties;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "api")
@Data
@Log
public class ApiProperties{
    private String url;
}
