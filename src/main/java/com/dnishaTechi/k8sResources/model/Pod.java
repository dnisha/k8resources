package com.dnishaTechi.k8sResources.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pod {
    private String name;
    private String ip;
    private String node;
}
