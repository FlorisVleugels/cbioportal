package org.cbioportal.web.parameter;

import java.io.Serializable;
import java.util.List;

public class NamespaceDataFilter extends DataFilter implements Serializable {

    private NamespaceIdentifier attributeId;

    public NamespaceIdentifier getAttributes() {
        return attributeId;
    }

    public void setAttributes(NamespaceIdentifier attributeId) {
        this.attributeId = attributeId;
    }

}