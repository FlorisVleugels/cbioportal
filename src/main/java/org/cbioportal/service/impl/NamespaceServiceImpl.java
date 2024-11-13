package org.cbioportal.service.impl;

import org.cbioportal.model.Namespace;
import org.cbioportal.persistence.NamespaceRepository;
import org.cbioportal.service.NamespaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NamespaceServiceImpl implements NamespaceService {

    @Autowired
    private NamespaceRepository namespaceRepository;

    @Override
    public List<Namespace> fetchOuterKey(List<String> OuterKey) {

        List<Namespace> namespaceList = namespaceRepository.getNamespaceOuterKey(OuterKey);
        
        return namespaceList;
    }
}