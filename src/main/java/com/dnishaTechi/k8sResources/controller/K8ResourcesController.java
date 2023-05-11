package com.dnishaTechi.k8sResources.controller;

import com.dnishaTechi.k8sResources.config.ApiConfig;
import com.dnishaTechi.k8sResources.properties.ApiProperties;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/k8/")
@AllArgsConstructor
@Log
public class K8ResourcesController {
    private final ApiConfig apiConfig;
    @GetMapping("/hello")
    public Mono<String> health() {
        log.info("got api url as: "+apiConfig.contructApi());
        return Mono.just("Hello from k8s resource service");
    }

    @GetMapping("/getPods")
    public Mono<String> getPods()  {
        WebClient webClient = WebClient.create(apiConfig.contructApi()+"/getPods"); // replace with the URL of the API endpoint you want to access
        return webClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .log();
    }
    @GetMapping("/getServices")
    public Mono<String> getService()  {
        WebClient webClient = WebClient.create(apiConfig.contructApi()+"/getServices"); // replace with the URL of the API endpoint you want to access
        return webClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .log();
    }
}
