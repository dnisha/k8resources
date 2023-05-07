package com.dnishaTechi.k8sResources.factory;

import com.dnishaTechi.k8sResources.model.Svc;
import io.kubernetes.client.openapi.models.V1Service;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory {
    private ServiceFactory(){

    }
    public static Svc create(final V1Service service){
    return new Svc(service.getMetadata().getName(), service.getSpec().getType(), service.getSpec().getClusterIP(), service.getSpec().getPorts().listIterator().next().getTargetPort().toString());
    }
}
