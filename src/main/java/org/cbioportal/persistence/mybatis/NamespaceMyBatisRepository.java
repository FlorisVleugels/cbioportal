package org.cbioportal.persistence.mybatis;

import org.cbioportal.model.Namespace;
import org.cbioportal.model.NamespaceAttributeCount;
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
    public NamespaceAttributeCount getNamespaceAttributeCountsBySampleIds(List<String> studyIds, List<String> sampleIds, String outerKey, String innerKey) {

        return namespaceMapper.getNamespaceAttributeCountsBySampleIds(studyIds, sampleIds, outerKey, innerKey);
    }

    @Override
    public List<NamespaceDataCount> getNamespaceDataCounts(List<String> studyIds, List<String> sampleIds, String outerKey, String innerKey) {

        return namespaceMapper.getNamespaceDataCounts(studyIds, sampleIds, outerKey, innerKey);
    }
}