package org.cbioportal.model;

import com.fasterxml.jackson.annotation.JsonRawValue;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.math.BigDecimal;

public class Namespace extends UniqueKeyBase implements Serializable {
    
    private String outerKey;
    private String innerKey;
    @JsonRawValue
    @Schema(type = "java.util.Map")
    
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