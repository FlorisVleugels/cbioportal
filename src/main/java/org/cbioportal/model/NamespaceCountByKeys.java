package org.cbioportal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class NamespaceCountByKeys extends Namespace {

    private Integer counts;

    public Integer getCounts() {
        return counts;
    }

    public void setEntrezGeneId(Integer counts) {
        this.counts = counts;
    }
}