package com.dnishaTechi.k8sResources.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PodWrapper {
   final private String kind = "pod";
    private List<Pod> pods;
}
