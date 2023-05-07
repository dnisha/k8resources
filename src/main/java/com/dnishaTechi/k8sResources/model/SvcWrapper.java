package com.dnishaTechi.k8sResources.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SvcWrapper {
   final private String kind = "service";
    private List<Svc> svc;
}
