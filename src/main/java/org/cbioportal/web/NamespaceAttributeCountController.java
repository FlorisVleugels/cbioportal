package org.cbioportal.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.cbioportal.model.NamespaceAttributeCount;
import org.cbioportal.service.NamespaceService;
import org.cbioportal.web.config.InternalApiTags;
import org.cbioportal.web.config.annotation.InternalApi;
import org.cbioportal.web.parameter.NamespaceAttributeCountFilter;
import org.cbioportal.web.parameter.SampleIdentifier;
import org.cbioportal.web.parameter.NamespaceIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@InternalApi
@RestController()
@RequestMapping("/api")
@Validated
@Tag(name = InternalApiTags.NAMESPACE_ATTRIBUTES_COUNT, description = " ")
public class NamespaceAttributeCountController {

    @Autowired
    private NamespaceService namespaceAttributeService;
 
    @PreAuthorize("hasPermission(#involvedCancerStudies, 'Collection<CancerStudyId>', T(org.cbioportal.utils.security.AccessLevel).READ)")
    @RequestMapping(value = "/namespace-attributes/counts/fetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Get counts for namespace attributes according to their data availability for selected samples/patients")
    @ApiResponse(responseCode = "200", description = "OK",
        content = @Content(array = @ArraySchema(schema = @Schema(implementation = NamespaceAttributeCount.class))))
    public ResponseEntity<List<NamespaceAttributeCount>> getNamespaceAttributeCounts(
        @Parameter(hidden = true) // prevent reference to this attribute in the swagger-ui interface
        @RequestAttribute(required = false, value = "involvedCancerStudies") Collection<String> involvedCancerStudies,
        @Parameter(hidden = true) // prevent reference to this attribute in the swagger-ui interface. this attribute is needed for the @PreAuthorize tag above.
        @Valid @RequestAttribute(required = false, value = "interceptedNamespaceAttributeCountFilter") NamespaceAttributeCountFilter interceptedNamespaceAttributeCountFilter,
            @Parameter(required = true, description = "List of SampleIdentifiers and NamespaceIdentifiers")
            @Valid @RequestBody(required = false) NamespaceAttributeCountFilter namespaceAttributeCountFilter) {

        List<NamespaceAttributeCount> namespaceAttributeCountList;
            List<SampleIdentifier> sampleIdentifiers = interceptedNamespaceAttributeCountFilter.getSampleIdentifiers();
            List<NamespaceIdentifier> namespaceIdentifiers = interceptedNamespaceAttributeCountFilter.getNamespaceIdentifiers();
            List<String> studyIds = new ArrayList<>();
            List<String> sampleIds = new ArrayList<>();
            for (SampleIdentifier sampleIdentifier : sampleIdentifiers) {
                studyIds.add(sampleIdentifier.getStudyId());
                sampleIds.add(sampleIdentifier.getSampleId());
            }
            List<String> outerKeys = new ArrayList<>();
            List<String> innerKeys = new ArrayList<>();
            for (NamespaceIdentifier namespaceIdentifier : namespaceIdentifiers) {
                outerKeys.add(namespaceIdentifier.getOuterKey());
                innerKeys.add(namespaceIdentifier.getInnerKey());
            }

            namespaceAttributeCountList = namespaceAttributeService.fetchNamespaceAttributeCountsBySampleIds(studyIds, sampleIds, outerKeys, innerKeys);

        return new ResponseEntity<>(namespaceAttributeCountList, HttpStatus.OK);
    }
}