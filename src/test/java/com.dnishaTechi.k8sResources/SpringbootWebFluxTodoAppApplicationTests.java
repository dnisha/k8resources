package com.dnishaTechi.k8sResources;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.util.Config;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;

@SpringBootTest
class SpringbootWebFluxTodoAppApplicationTests {
	@Test
	public void testGetPods() {
		KubernetesClient client = new KubernetesClientBuilder().build();
		String namespace = "default";
		Mono<String> podsMono = Mono.just(client.getNamespace());
		StepVerifier.create(podsMono)
				.expectNextCount(1)
				.verifyComplete();
	}

}