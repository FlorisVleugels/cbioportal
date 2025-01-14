package org.cbioportal.web.util;

import org.apache.commons.collections4.map.MultiKeyMap;
import org.cbioportal.model.NamespaceData;
import org.cbioportal.service.NamespaceDataService;
import org.cbioportal.web.parameter.NamespaceDataFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NamespaceDataEqualityFilterApplier extends NamespaceDataFilterApplier {

    @Autowired
    public NamespaceDataEqualityFilterApplier(NamespaceDataService namespaceDataService,
            StudyViewFilterUtil studyViewFilterUtil) {
        super(namespaceDataService, studyViewFilterUtil);
    }

    @Autowired
    private StudyViewFilterUtil studyViewFilterUtil;

    @Override
    public Integer apply(List<NamespaceDataFilter> attributes,
            MultiKeyMap namespaceDataMap,
            String entityId,
            String studyId,
            boolean negateFilters
            ) {
        return studyViewFilterUtil.getFilteredCountByNamespaceDataEquality(attributes, namespaceDataMap, entityId, studyId, negateFilters);
            }

}