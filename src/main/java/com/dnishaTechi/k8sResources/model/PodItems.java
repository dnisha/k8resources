package com.dnishaTechi.k8sResources.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class PodItems {
    @JsonProperty("metadata")
    private PodMetadata podMetadata;
    @JsonProperty("status")
    private PodStatus status;
}
