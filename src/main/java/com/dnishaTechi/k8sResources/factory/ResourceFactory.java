package com.dnishaTechi.k8sResources.factory;

import com.dnishaTechi.k8sResources.model.FinalResponse;
import com.dnishaTechi.k8sResources.model.PodResponse;
import com.dnishaTechi.k8sResources.model.SvcResponse;
import reactor.util.function.Tuple2;

public class ResourceFactory {
    private ResourceFactory(){

    }

    public static FinalResponse create(final Tuple2<PodResponse, SvcResponse> tuple2){
        return new FinalResponse(tuple2.getT1(), tuple2.getT2());
    }
}
