package com.dnishaTechi.k8sResources.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class K8Resource {
    private PodWrapper podWrapper;
    private SvcWrapper svcWrapper;
}
