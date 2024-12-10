package org.cbioportal.service.impl;

import org.cbioportal.model.Namespace;
import org.cbioportal.model.NamespaceAttributeCount;
import org.cbioportal.persistence.NamespaceRepository;
import org.cbioportal.service.NamespaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class NamespaceServiceImpl implements NamespaceService {

    @Autowired
    private NamespaceRepository namespaceRepository;

    @Override
    public List<Namespace> fetchNamespaceKeys(List<String> studyIds) {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Namespace> outerKeys = namespaceRepository.getNamespaceOuterKey(studyIds);
        List<Namespace> combinedNamespaces = new ArrayList<>();

        for (Namespace outerNamespaceKey : outerKeys) {
        try {
            // Parse the JSON string in outerKey to extract actual keys
            String outerKeyJson = outerNamespaceKey.getOuterKey();
            List<String> outerKeyList = objectMapper.readValue(outerKeyJson, new TypeReference<List<String>>() {});

            for (String outerKey : outerKeyList) {
                // Fetch inner keys for each outer key
                List<Namespace> innerKeys = namespaceRepository.getNamespaceInnerKey(outerKey, studyIds);

                for (Namespace innerNamespaceKey : innerKeys) {
                    // Parse the JSON string in innerKey to extract individual keys
                    String innerKeyJson = innerNamespaceKey.getInnerKey();
                    List<String> innerKeyList = objectMapper.readValue(innerKeyJson, new TypeReference<List<String>>() {});

                    for (String innerKey : innerKeyList) {
                        // Create a new Namespace object for each innerKey
                        Namespace unpackedNamespace = new Namespace();
                        unpackedNamespace.setOuterKey(outerKey);
                        unpackedNamespace.setInnerKey(innerKey);

                        combinedNamespaces.add(unpackedNamespace);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to parse keys for outer key: " + outerNamespaceKey.getOuterKey());
            e.printStackTrace();
        }
    }

        return combinedNamespaces;
    }

    @Override
    public List<NamespaceAttributeCount> fetchNamespaceAttributeCountsBySampleIds(List<String> studyIds, List<String> sampleIds, List<String> outerKeys, List<String> innerKeys) {

        List<NamespaceAttributeCount> combinedNamespaceAttributeCount = new ArrayList<>();
        
        // size of outerKeys and innerKeys should always be the same but should add some check
        for (int i = 0; i < outerKeys.size(); i++) {
            String outerKey = outerKeys.get(i);
            String innerKey = innerKeys.get(i);
            NamespaceAttributeCount namespaceAttributeCount = namespaceRepository.getNamespaceAttributeCountsBySampleIds(studyIds, sampleIds, outerKey, innerKey);
            combinedNamespaceAttributeCount.add(namespaceAttributeCount);
        }

        return combinedNamespaceAttributeCount;
    }

}