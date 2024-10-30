package org.cbioportal.model;

import com.fasterxml.jackson.annotation.JsonRawValue;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.math.BigDecimal;

public class Namespace extends Alteration implements Serializable {
    
    private String keyword;
    @JsonRawValue
    @Schema(type = "java.util.Map")
    private Object annotationJSON;
    

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Object getAnnotationJSON() {
        return annotationJSON;
    }

    public void setAnnotationJSON(String annotationJSON) {
        this.annotationJSON = annotationJSON;
    }

}