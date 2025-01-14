package org.cbioportal.persistence;

import org.cbioportal.model.Namespace;
import org.cbioportal.model.NamespaceAttributeCount;
import org.cbioportal.model.NamespaceData;
import org.cbioportal.model.NamespaceDataCount;
// import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface NamespaceRepository {

    // @Cacheable(cacheResolver = "generalRepositoryCacheResolver", condition = "@cacheEnabledConfig.getEnabled()")
    List<Namespace> getNamespaceOuterKey(List<String> studyIds);

    List<Namespace> getNamespaceInnerKey(String outerKey, List<String> studyIds);

    NamespaceAttributeCount getNamespaceAttributeCountsBySampleIds(List<String> studyIds, List<String> sampleIds, String outerKey, String innerKey);

    List<NamespaceDataCount> getNamespaceDataCounts(List<String> studyIds, List<String> sampleIds, String outerKey, String innerKey);

    List<NamespaceData> getNamespaceData(List<String> studyIds, List<String> sampleIds, String outerKey, String innerKey);
}