package org.cbioportal.web.parameter;

import java.io.Serializable;
import java.util.List;

public class NamespaceDataFilter extends DataFilter implements Serializable {

    private String innerKey;
    private String outerKey;

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