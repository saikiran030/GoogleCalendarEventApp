
package com.java4geeks.calendar.google.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "createRequest",
    "entryPoints",
    "conferenceSolution",
    "conferenceId",
    "signature",
    "notes"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConferenceData {

    @JsonProperty("createRequest")
    private CreateRequest createRequest;
    @JsonProperty("entryPoints")
    private List<EntryPoint> entryPoints = null;
    @JsonProperty("conferenceSolution")
    private ConferenceSolution conferenceSolution;
    @JsonProperty("conferenceId")
    private String conferenceId;
    @JsonProperty("signature")
    private String signature;
    @JsonProperty("notes")
    private String notes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("createRequest")
    public CreateRequest getCreateRequest() {
        return createRequest;
    }

    @JsonProperty("createRequest")
    public void setCreateRequest(CreateRequest createRequest) {
        this.createRequest = createRequest;
    }

    @JsonProperty("entryPoints")
    public List<EntryPoint> getEntryPoints() {
        return entryPoints;
    }

    @JsonProperty("entryPoints")
    public void setEntryPoints(List<EntryPoint> entryPoints) {
        this.entryPoints = entryPoints;
    }

    @JsonProperty("conferenceSolution")
    public ConferenceSolution getConferenceSolution() {
        return conferenceSolution;
    }

    @JsonProperty("conferenceSolution")
    public void setConferenceSolution(ConferenceSolution conferenceSolution) {
        this.conferenceSolution = conferenceSolution;
    }

    @JsonProperty("conferenceId")
    public String getConferenceId() {
        return conferenceId;
    }

    @JsonProperty("conferenceId")
    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
    }

    @JsonProperty("signature")
    public String getSignature() {
        return signature;
    }

    @JsonProperty("signature")
    public void setSignature(String signature) {
        this.signature = signature;
    }

    @JsonProperty("notes")
    public String getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
