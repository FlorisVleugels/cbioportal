package org.cbioportal.model;

import java.io.Serializable;

public class Namespace implements Serializable {
    
    private String outerKey;
    private String innerKey;
    
    public String getOuterKey() {
        return outerKey;
    }

    public void setOuterKey(String outerKey) {
        this.outerKey = outerKey;
    }

    public String getInnerKey() {
        return innerKey;
    }

    public void setInnerKey(String innerKey) {
        this.innerKey = innerKey;
    }
}