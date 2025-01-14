package org.cbioportal.service.impl;

import org.cbioportal.model.NamespaceData;
import org.cbioportal.persistence.NamespaceRepository;
import org.cbioportal.service.NamespaceDataService;
import org.cbioportal.web.parameter.NamespaceDataFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.util.Pair;
import java.util.stream.Collectors;

@Service
public class NamespaceDataServiceImpl implements NamespaceDataService {

    @Autowired
    private NamespaceRepository namespaceRepository;

    @Override
    public List<NamespaceData> fetchNamespaceData(List<String> studyIds, List<String> sampleIds, List<NamespaceDataFilter> namespaceDataFitlers) {

        if (sampleIds.isEmpty()) {
            return new ArrayList<>();
        }

        return namespaceDataFitlers.stream().map(namespaceDataFilter-> {
            String outerKey = namespaceDataFilter.getOuterKey();
            String innerKey = namespaceDataFilter.getInnerKey();

            return namespaceRepository.getNamespaceData(studyIds, sampleIds, outerKey, innerKey);

        }).flatMap(List::stream).collect(Collectors.toList());
        
    }
}