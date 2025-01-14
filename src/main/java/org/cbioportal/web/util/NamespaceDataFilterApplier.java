package org.cbioportal.web.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;
import org.apache.commons.math3.util.Pair;

import org.apache.commons.collections4.map.MultiKeyMap;
import org.cbioportal.model.NamespaceData;
import org.cbioportal.service.NamespaceDataService;
import org.cbioportal.web.parameter.NamespaceDataFilter;
import org.cbioportal.web.parameter.SampleIdentifier;

import org.springframework.stereotype.Component;

@Component
public abstract class NamespaceDataFilterApplier implements DataFilterApplier<NamespaceDataFilter> {
    private NamespaceDataService namespaceDataService;
    protected StudyViewFilterUtil studyViewFilterUtil;

    public NamespaceDataFilterApplier(
        NamespaceDataService namespaceDataService,
        StudyViewFilterUtil studyViewFilterUtil
    ) {
        this.namespaceDataService = namespaceDataService;
        this.studyViewFilterUtil = studyViewFilterUtil;
    }

    @Override
    public List<SampleIdentifier> apply(
        List<SampleIdentifier> sampleIdentifiers,
        List<NamespaceDataFilter> namespaceDataFilters,
        boolean negateFilters
        ) {
        if (!namespaceDataFilters.isEmpty() && !sampleIdentifiers.isEmpty()) {
            List<String> studyIds = new ArrayList<>();
            List<String> sampleIds = new ArrayList<>();

            studyViewFilterUtil.extractStudyAndSampleIds(sampleIdentifiers, studyIds, sampleIds);

            List<NamespaceData> namespaceDataList = namespaceDataService.fetchNamespaceData(studyIds, sampleIds, namespaceDataFilters);

            namespaceDataList.forEach(n -> {

                if (n.getAttrValue() == null) {
                    n.setAttrValue(Collections.singletonList("NA"));
                }
                
                List<String> updatedAttrValues = n.getAttrValue().stream()
                    .map(value -> {
                        value = value.toUpperCase();
                        if (value.equals("NAN") || value.equals("N/A")) {
                            value = "NA";
                        }
                        return value;
                    })
                .collect(Collectors.toList());
                n.setAttrValue(updatedAttrValues);
            });

            //MultiKeyMap namespaceDataMap = new MultiKeyMap();
            MultiKeyMap<String, List<String>> namespaceDataMap = new MultiKeyMap<>();
            for (NamespaceData namespaceData : namespaceDataList) {
                namespaceDataMap.put(namespaceData.getStudyId(), namespaceData.getSampleId(), namespaceData.getOuterKey(),
                        namespaceData.getInnerKey(), namespaceData.getAttrValue());
            }

            List<SampleIdentifier> newSampleIdentifiers = new ArrayList<>();
            sampleIdentifiers.forEach(sampleIdentifier -> {
                int count = apply(namespaceDataFilters, namespaceDataMap, sampleIdentifier.getSampleId(),
                        sampleIdentifier.getStudyId(), negateFilters);

                if (count == namespaceDataFilters.size()) {
                    newSampleIdentifiers.add(sampleIdentifier);
                }
            });

            return newSampleIdentifiers;
        }
        return sampleIdentifiers;
        }

    // Must be overridden by child classes
    protected abstract Integer apply(List<NamespaceDataFilter> attributes, MultiKeyMap namespaceDataMap, String entityId, String studyId, boolean negateFilters);
}