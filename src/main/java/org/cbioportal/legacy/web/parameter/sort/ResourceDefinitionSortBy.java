package org.cbioportal.legacy.web.parameter.sort;

public enum ResourceDefinitionSortBy {
  resourceId("resourceId"),
  displayName("displayName"),
  description("description"),
  resourceType("resourceType"),
  priority("priority"),
  openByDefault("openByDefault"),
  studyId("cancerStudyIdentifier"),
  customMetaData("customMetaData");

  private String originalValue;

  ResourceDefinitionSortBy(String originalValue) {
    this.originalValue = originalValue;
  }

  public String getOriginalValue() {
    return originalValue;
  }
}
