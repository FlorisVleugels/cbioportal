package org.cbioportal.service;

import org.cbioportal.model.NamespaceDataCountItem;

import java.util.List;

public interface NamespaceCountService {
    
    NamespaceDataCountItem fetchNamespaceDataCounts(List<String> studyIds, List<String> sampleIds, String outerKey, String innerKey);
}