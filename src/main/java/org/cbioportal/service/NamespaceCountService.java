package org.cbioportal.service;

import org.cbioportal.model.NamespaceDataCount;

import java.util.List;

public interface NamespaceCountService {
    
    List<NamespaceDataCount> fetchNamespaceDataCounts(String outerKey, String innerKey);
}