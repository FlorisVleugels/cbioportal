package org.cbioportal.persistence;

import org.cbioportal.model.Namespace;
import org.cbioportal.model.NamespaceDataCount;
// import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface NamespaceRepository {

    // @Cacheable(cacheResolver = "generalRepositoryCacheResolver", condition = "@cacheEnabledConfig.getEnabled()")
    List<Namespace> getNamespaceOuterKey(List<String> studyIds);
    List<Namespace> getNamespaceInnerKey(String outerKey, List<String> studyIds);

    List<NamespaceDataCount> getNamespaceDataCounts(String outerKey, String innerKey);
}