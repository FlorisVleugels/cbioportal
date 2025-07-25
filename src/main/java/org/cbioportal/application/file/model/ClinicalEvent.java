package org.cbioportal.application.file.model;

public class ClinicalEvent {
  private Integer clinicalEventId;
  private String patientId;
  private String eventType;
  private Integer startDate;
  private Integer stopDate;

  public Integer getClinicalEventId() {
    return clinicalEventId;
  }

  public void setClinicalEventId(Integer clinicalEventId) {
    this.clinicalEventId = clinicalEventId;
  }

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public Integer getStartDate() {
    return startDate;
  }

  public void setStartDate(Integer startDate) {
    this.startDate = startDate;
  }

  public Integer getStopDate() {
    return stopDate;
  }

  public void setStopDate(Integer stopDate) {
    this.stopDate = stopDate;
  }
}
