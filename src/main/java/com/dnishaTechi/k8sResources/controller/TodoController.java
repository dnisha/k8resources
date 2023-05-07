package com.dnishaTechi.k8sResources.controller;
import com.dnishaTechi.k8sResources.factory.*;
import com.dnishaTechi.k8sResources.model.K8Resource;
import com.dnishaTechi.k8sResources.model.SvcWrapper;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.openapi.models.V1ServiceList;
import io.kubernetes.client.util.Config;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/k8/")
public class TodoController {
    @GetMapping("/health")
    public Mono<String> health() {
        return Mono.just("Hello from k8s resource service");
    }

    @GetMapping("/getResources")
    public Mono<K8Resource> getPods() throws IOException, ApiException {
        ApiClient client = Config.defaultClient();
        CoreV1Api api = new CoreV1Api(client);
        return Mono.fromCallable(() -> api.listNamespacedPod("default", null, null, null, null, null, null, null, null, null, null))
                .flatMapIterable(V1PodList::getItems)
                .flatMap(p -> Mono.just(PodsFactory.create(p)))
                .collectList()
                .flatMap(l -> Mono.just(PodsWraaperFactory.create(l)))
                .zipWith(getService())
                .map(t2 -> K8ResourceFactory.create(t2.getT1(), t2.getT2()))
                .log();
    }
    private Mono<SvcWrapper> getService() throws IOException, ApiException {
        ApiClient client = Config.defaultClient();
        CoreV1Api api = new CoreV1Api(client);
        V1ServiceList serviceList = api.listNamespacedService("default", null, null, null, null, null, null, null, null, null, null);

       return Flux.fromIterable(serviceList.getItems())
               .map(ServiceFactory::create)
               .collectList()
               .map(w -> SvcWraaperFactory.create(w))
               .log();

    }

}
