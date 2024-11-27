package org.cbioportal.web.parameter;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

public class NamespaceKeyIdentifier {

    @Size(min = 1, max = PagingConstants.MAX_PAGE_SIZE)
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