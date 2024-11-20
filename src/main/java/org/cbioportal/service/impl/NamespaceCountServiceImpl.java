package org.cbioportal.service.impl;

import org.cbioportal.model.NamespaceCountByKeys;
import org.cbioportal.persistence.NamespaceRepository;
import org.cbioportal.service.NamespaceCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class NamespaceCountServiceImpl implements NamespaceCountService {

    @Autowired
    private NamespaceRepository namespaceRepository;

    @Override
    public List<NamespaceCountByKeys> fetchNamespaceCountByKeys(String outerKey, String innerKey) {

        List<NamespaceCountByKeys> counts = namespaceRepository.getNamespaceCountByKeys(outerKey, innerKey);

        return counts;
    }
}
