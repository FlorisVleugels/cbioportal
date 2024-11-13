package org.cbioportal.model;

import com.fasterxml.jackson.annotation.JsonRawValue;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.math.BigDecimal;

public class Namespace extends UniqueKeyBase implements Serializable {
    
    private String outerKey;
    @JsonRawValue
    @Schema(type = "java.util.Map")
    private Object annotationJSON;
    

    public String getOuterKey() {
        return outerKey;
    }

    public void setOuterKey(String outerKey) {
        this.outerKey = outerKey;
    }

    public Object getAnnotationJSON() {
        return annotationJSON;
    }

    public void setAnnotationJSON(String annotationJSON) {
        this.annotationJSON = annotationJSON;
    }

}