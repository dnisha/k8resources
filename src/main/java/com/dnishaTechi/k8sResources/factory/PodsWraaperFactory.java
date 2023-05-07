package com.dnishaTechi.k8sResources.factory;

import com.dnishaTechi.k8sResources.model.Pod;
import com.dnishaTechi.k8sResources.model.PodWrapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PodsWraaperFactory {
    private PodsWraaperFactory(){

    }
    public static PodWrapper create(final List<Pod> podArrayList){
    return new PodWrapper(podArrayList);
    }
}
