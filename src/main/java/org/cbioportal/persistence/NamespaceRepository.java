package org.cbioportal.persistence;

import org.cbioportal.model.Namespace;
// import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface NamespaceRepository {

    // @Cacheable(cacheResolver = "generalRepositoryCacheResolver", condition = "@cacheEnabledConfig.getEnabled()")
    List<Namespace> getNamespaceOuterKey();
}