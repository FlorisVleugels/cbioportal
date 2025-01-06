package org.cbioportal.service;

import org.cbioportal.model.NamespaceDataCount;

import java.util.List;

public interface NamespaceCountService {
    
    List<NamespaceDataCount> fetchNamespaceDataCounts(List<String> studyIds, List<String> sampleIds, String outerKey, String innerKey);
}