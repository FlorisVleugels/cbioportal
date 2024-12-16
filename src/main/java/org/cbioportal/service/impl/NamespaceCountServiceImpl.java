package org.cbioportal.service.impl;

import org.cbioportal.model.NamespaceDataCountItem;
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
    public NamespaceDataCountItem fetchNamespaceDataCounts(List<String> studyIds, List<String> sampleIds, String outerKey, String innerKey) {

        return namespaceRepository.getNamespaceDataCounts(studyIds, sampleIds, outerKey, innerKey);
    }
}