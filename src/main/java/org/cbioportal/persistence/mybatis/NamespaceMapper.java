package org.cbioportal.persistence.mybatis;

import org.cbioportal.model.Namespace;
import org.cbioportal.model.NamespaceAttributeCount;
import org.cbioportal.model.NamespaceDataCountItem;

import java.util.List;

public interface NamespaceMapper{

    List<Namespace> getNamespaceOuterKey(List<String> studyIds);

    List<Namespace> getNamespaceInnerKey(String outerKey, List<String> studyIds);

    NamespaceAttributeCount getNamespaceAttributeCountsBySampleIds(List<String> studyIds, List<String> sampleIds, String outerKey, String innerKey);

    NamespaceDataCountItem getNamespaceDataCounts(List<String> studyIds, List<String> sampleIds, String outerKey, String innerKey);
}