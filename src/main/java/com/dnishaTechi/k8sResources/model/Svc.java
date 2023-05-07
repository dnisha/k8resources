package com.dnishaTechi.k8sResources.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Svc {
    private String name;
    private String type;
    private String clusterIp;
    private String ports;
}
