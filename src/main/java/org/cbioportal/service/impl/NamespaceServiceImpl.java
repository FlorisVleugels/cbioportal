package org.cbioportal.service.impl;

import org.cbioportal.model.Namespace;
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

            String outerKeyJson = outerNamespaceKey.getOuterKey();
            List<String> outerKeyList = objectMapper.readValue(outerKeyJson, new TypeReference<List<String>>() {});

            for (String outerKey : outerKeyList) {

                List<Namespace> innerKeys = namespaceRepository.getNamespaceInnerKey(outerKey, studyIds);

                for (Namespace innerNamespaceKey : innerKeys) {

                    String innerKeyJson = innerNamespaceKey.getInnerKeyJson();
                    List<String> innerKeyList = objectMapper.readValue(innerKeyJson, new TypeReference<List<String>>() {});

                    Namespace unpackedNamespace = new Namespace();
                    unpackedNamespace.setOuterKey(outerKey);
                    unpackedNamespace.setInnerKey(innerKeyList);
                    combinedNamespaces.add(unpackedNamespace);
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to parse keys for outer key: " + outerNamespaceKey.getOuterKey());
            e.printStackTrace();
        }
    }

        return combinedNamespaces;
    }
}