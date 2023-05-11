package com.dnishaTechi.k8sResources.config;

import com.dnishaTechi.k8sResources.properties.ApiProperties;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiConfig {
    @Autowired
    private ApiProperties apiProperties;
    public String contructApi(){
        return apiProperties.getUrl();
    }

}
