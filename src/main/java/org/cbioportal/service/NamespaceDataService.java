package org.cbioportal.service;

import org.cbioportal.model.NamespaceData;
import org.cbioportal.web.parameter.NamespaceDataFilter;
import java.util.List;
import org.apache.commons.math3.util.Pair;


public interface NamespaceDataService {

    List<NamespaceData> fetchNamespaceData(List<String> studyIds, List<String> ids, List<NamespaceDataFilter> namespaceDataFilters);
}