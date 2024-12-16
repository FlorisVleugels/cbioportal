package org.cbioportal.web.parameter;

import java.io.Serializable;
import java.util.List;

public class NamespaceDataCountFilter implements Serializable {

    private List<NamespaceDataFilter> namespaceDataFilters;
    private StudyViewFilter studyViewFilter;

    public List<NamespaceDataFilter> getNamespaceDataFilters() {
        return namespaceDataFilters;
    }

    public void setNamespaceDataFilters(List<NamespaceDataFilter> namespaceDataFilters) {
        this.namespaceDataFilters = namespaceDataFilters;
    }

    public StudyViewFilter getStudyViewFilter() {
        return studyViewFilter;
    }

    public void setStudyViewFilter(StudyViewFilter studyViewFilter) {
        this.studyViewFilter = studyViewFilter;
    }
}