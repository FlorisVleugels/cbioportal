package org.cbioportal.persistence.mybatis;

import org.cbioportal.model.Namespace;
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
    public List<Namespace> getNamespaceOuterKey() {

        return namespaceMapper.getNamespaceOuterKey();
    }

    @Override
    public List<Namespace> getNamespaceInnerKey(String outerKey) {

        return namespaceMapper.getNamespaceInnerKey(outerKey);
    }
}