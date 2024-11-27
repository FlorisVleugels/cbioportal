package org.cbioportal.model;

import java.io.Serializable;
import java.util.List;

public class NamespaceDataCountItem implements Serializable {

    private String outerKey;
    private String innerKey;
    private List<NamespaceDataCount> counts;

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

    public List<NamespaceDataCount> getCounts() {
        return counts;
    }

    public void setCounts(List<NamespaceDataCount> counts) {
        this.counts = counts;
    }
}
