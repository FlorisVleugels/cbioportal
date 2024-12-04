package org.cbioportal.persistence.mybatis;

import org.cbioportal.model.Namespace;
import org.cbioportal.model.NamespaceDataCount;

import java.util.List;

public interface NamespaceMapper{

    List<Namespace> getNamespaceOuterKey(List<String> studyIds);
    List<Namespace> getNamespaceInnerKey(String outerKey, List<String> studyIds);

    List<Namespace> getNamespaceOuterKeyReal(List<String> studyIds);
    List<Namespace> getNamespaceInnerKeyReal(String outerKey, List<String> studyIds);

    List<NamespaceDataCount> getNamespaceDataCounts(String outerKey, String innerKey);
}