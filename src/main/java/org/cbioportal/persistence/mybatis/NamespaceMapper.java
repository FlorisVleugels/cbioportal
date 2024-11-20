package org.cbioportal.persistence.mybatis;

import org.cbioportal.model.Namespace;
import org.cbioportal.model.NamespaceCountByKeys;

import java.util.List;

public interface NamespaceMapper{

    List<Namespace> getNamespaceOuterKey();

    List<Namespace> getNamespaceInnerKey(String outerKey);

    List<NamespaceCountByKeys> getNamespaceCountByKeys(String outerKey, String innerKey);
}