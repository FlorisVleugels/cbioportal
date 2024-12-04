package org.cbioportal.persistence.mybatis;

import org.cbioportal.model.Namespace;
import org.cbioportal.model.NamespaceDataCount;
import org.cbioportal.persistence.NamespaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class NamespaceMyBatisRepository implements NamespaceRepository {

    @Autowired
    private NamespaceMapper namespaceMapper;

    @Override
    public List<Namespace> getNamespaceOuterKey(List<String> studyIds) {

        return namespaceMapper.getNamespaceOuterKey(studyIds);
    }

    @Override
    public List<Namespace> getNamespaceInnerKey(String outerKey, List<String> studyIds) {

        return namespaceMapper.getNamespaceInnerKey(outerKey, studyIds);
    }

    @Override
    public List<Namespace> getNamespaceOuterKeyReal(List<String> studyIds) {

        return namespaceMapper.getNamespaceOuterKeyReal(studyIds);
    }

    @Override
    public List<Namespace> getNamespaceInnerKeyReal(String outerKey, List<String> studyIds) {

        return namespaceMapper.getNamespaceInnerKeyReal(outerKey, studyIds);
    }

    @Override
    public List<NamespaceDataCount> getNamespaceDataCounts(String outerKey, String innerKey) {

        return namespaceMapper.getNamespaceDataCounts(outerKey, innerKey);
    }
}