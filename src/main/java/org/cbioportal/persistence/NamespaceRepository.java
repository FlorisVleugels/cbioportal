package org.cbioportal.persistence;

import org.cbioportal.model.Namespace;
import org.cbioportal.model.NamespaceCountByKeys;
// import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface NamespaceRepository {

    // @Cacheable(cacheResolver = "generalRepositoryCacheResolver", condition = "@cacheEnabledConfig.getEnabled()")
    List<Namespace> getNamespaceOuterKey();

    List<Namespace> getNamespaceInnerKey(String outerKey);

    List<NamespaceCountByKeys> getNamespaceCountByKeys(String outerKey, String innerKey);
}