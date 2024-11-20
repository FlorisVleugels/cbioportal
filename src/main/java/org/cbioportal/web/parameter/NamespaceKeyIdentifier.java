package org.cbioportal.web.parameter;

public class NamespaceKeyIdentifier {

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
