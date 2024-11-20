package org.cbioportal.service;

import org.cbioportal.model.NamespaceCountByKeys;

import java.util.List;

public interface NamespaceCountService {
    
    List<NamespaceCountByKeys> fetchNamespaceCountByKeys(String outerKey, String innerKey);
}