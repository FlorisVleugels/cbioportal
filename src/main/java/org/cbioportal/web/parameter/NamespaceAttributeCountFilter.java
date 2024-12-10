package org.cbioportal.web.parameter;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.io.Serializable;

public class NamespaceAttributeCountFilter implements Serializable {

    @Size(min = 1, max = PagingConstants.MAX_PAGE_SIZE)
    private List<SampleIdentifier> sampleIdentifiers;
    private List<NamespaceIdentifier> namespaceIdentifiers;

    @AssertTrue
    private boolean isBothSampleIdentifiersAndNamespaceIdentifiersPresent() {
        return sampleIdentifiers != null && namespaceIdentifiers != null;
    }

    public List<SampleIdentifier> getSampleIdentifiers() {
        return sampleIdentifiers;
    }

    public void setSampleIdentifiers(List<SampleIdentifier> sampleIdentifiers) {
        this.sampleIdentifiers = sampleIdentifiers;
    }

    public List<NamespaceIdentifier> getNamespaceIdentifiers() {
        return namespaceIdentifiers;
    }

    public void setNamespaceIdentifiers(List<NamespaceIdentifier> namespaceIdentifiers) {
        this.namespaceIdentifiers = namespaceIdentifiers;
    }
}