package org.cbioportal.persistence.mybatis;

import org.cbioportal.model.Namespace;
import org.cbioportal.model.NamespaceDataCount;

import java.util.List;

public interface NamespaceMapper{

    List<Namespace> getNamespaceOuterKey();

    List<Namespace> getNamespaceInnerKey(String outerKey);

    List<NamespaceDataCount> getNamespaceDataCounts(String outerKey, String innerKey);
}