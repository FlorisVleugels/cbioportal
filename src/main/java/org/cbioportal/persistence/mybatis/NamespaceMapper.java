package org.cbioportal.persistence.mybatis;

import org.cbioportal.model.Namespace;

import java.util.List;

public interface NamespaceMapper{

    List<Namespace> getNamespaceOuterKey();

    List<Namespace> getNamespaceInnerKey(String outerKey);
}
