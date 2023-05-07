package com.dnishaTechi.k8sResources.factory;

import com.dnishaTechi.k8sResources.model.K8Resource;
import com.dnishaTechi.k8sResources.model.PodWrapper;
import com.dnishaTechi.k8sResources.model.SvcWrapper;
import org.springframework.stereotype.Component;

@Component
public class K8ResourceFactory {
    private K8ResourceFactory(){

    }
    public static K8Resource create(final PodWrapper podWrapper, final SvcWrapper svcWrapper){
    return new K8Resource(podWrapper, svcWrapper);
    }
}
