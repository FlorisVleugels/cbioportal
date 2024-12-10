package org.cbioportal.service;

import org.cbioportal.model.Namespace;
import org.cbioportal.model.NamespaceAttributeCount;

import java.util.List;

public interface NamespaceService {

    List<Namespace> fetchNamespaceKeys(List<String> studyIds);

    List<NamespaceAttributeCount> fetchNamespaceAttributeCountsBySampleIds(List<String> studyIds, List<String> sampleIds, List<String> outerKeys, List<String> innerKeys);
}