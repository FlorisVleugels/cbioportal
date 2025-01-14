package org.cbioportal.model;

import java.io.Serializable;
import java.util.List;
import jakarta.validation.constraints.NotNull;

public class NamespaceData implements Serializable {
    
    @NotNull
    private String outerKey;
    @NotNull
    private String innerKey;
    private String sampleId;
    @NotNull
    private String studyId;
    private List<String> attrValue;

    
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

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public String getStudyId() {
        return studyId;
    }

    public void setStudyId(String studyId) {
        this.studyId = studyId;
    }

    public List<String> getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(List<String> attrValue) {
        this.attrValue = attrValue;
    }

}