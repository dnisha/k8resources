package com.dnishaTechi.k8sResources.controller;

import com.dnishaTechi.k8sResources.config.ApiConfig;
import com.dnishaTechi.k8sResources.factory.ResourceFactory;
import com.dnishaTechi.k8sResources.model.FinalResponse;
import com.dnishaTechi.k8sResources.model.PodResponse;
import com.dnishaTechi.k8sResources.model.SvcResponse;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
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
    public Mono<PodResponse> getPods()  {
        WebClient webClient = WebClient.create(apiConfig.contructApi()+"/getPods"); // replace with the URL of the API endpoint you want to access
        return webClient.get()
                .retrieve()
                .bodyToMono(PodResponse.class)
                .log();
    }
    @GetMapping("/getServices")
    public Mono<SvcResponse> getService()  {
        WebClient webClient = WebClient.create(apiConfig.contructApi()+"/getServices"); // replace with the URL of the API endpoint you want to access
        return webClient.get()
                .retrieve()
                .bodyToMono(SvcResponse.class)
                .log();
    }
    @GetMapping("/getResource")
    public Mono<FinalResponse> getResource()  {
        WebClient webForPod = WebClient.create(apiConfig.contructApi()+"/getPods"); // replace with the URL of the API endpoint you want to access
        WebClient webForSvc = WebClient.create(apiConfig.contructApi()+"/getServices");
        return webForPod.get()
                .retrieve()
                .bodyToMono(PodResponse.class)
                .zipWith(webForSvc.get()
                        .retrieve()
                        .bodyToMono(SvcResponse.class))
                .map(tuple2 -> ResourceFactory.create(tuple2))
                .log();
    }
}
