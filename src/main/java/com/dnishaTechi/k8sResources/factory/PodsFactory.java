package com.dnishaTechi.k8sResources.factory;

import com.dnishaTechi.k8sResources.model.Pod;
import io.kubernetes.client.openapi.models.V1Pod;
import org.springframework.stereotype.Component;

@Component
public class PodsFactory {
    private PodsFactory(){

    }
    public static Pod create(final V1Pod v1Pod){
    return new Pod(v1Pod.getMetadata().getName(), v1Pod.getStatus().getPodIP(), v1Pod.getSpec().getNodeName());
    }
}
