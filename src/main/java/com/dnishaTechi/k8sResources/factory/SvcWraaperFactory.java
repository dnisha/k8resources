package com.dnishaTechi.k8sResources.factory;

import com.dnishaTechi.k8sResources.model.Svc;
import com.dnishaTechi.k8sResources.model.SvcWrapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SvcWraaperFactory {
    private SvcWraaperFactory(){

    }
    public static SvcWrapper create(final List<Svc> podArrayList){
    return new SvcWrapper(podArrayList);
    }
}
