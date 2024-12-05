package org.cbioportal.model;

import java.io.Serializable;
import java.util.List;

public class Namespace implements Serializable {
    
    private String outerKey;
    private String innerKeyJson;
    private List<String> innerKey;

    public String getInnerKeyJson() {
        return innerKeyJson;
    }

    public void setInnerKeyJson(String innerKeyJson) {
        this.innerKeyJson = innerKeyJson;
    }
    
    public String getOuterKey() {
        return outerKey;
    }

    public void setOuterKey(String outerKey) {
        this.outerKey = outerKey;
    }

    public List<String> getInnerKey() {
        return innerKey;
    }

    public void setInnerKey(List<String> innerKey) {
        this.innerKey = innerKey;
    }
}