package org.cbioportal.model;

import java.io.Serializable;
import java.util.List;

public class NamespaceDataCountItem extends Namespace{

    private List<NamespaceDataCount> counts;

    public List<NamespaceDataCount> getCounts() {
        return counts;
    }

    public void setCounts(List<NamespaceDataCount> counts) {
        this.counts = counts;
    }
}
