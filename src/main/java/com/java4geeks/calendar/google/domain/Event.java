
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
    "id",
    "description",
    "location",
    "organizer",
    "start",
    "end",
    "attendees",
    "hangoutLink",
    "source",
    "summary",
    "conferenceData"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

    @JsonProperty("id")
    private String id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("location")
    private String location;
    @JsonProperty("organizer")
    private Organizer organizer;
    @JsonProperty("start")
    private Start start;
    @JsonProperty("end")
    private End end;
    @JsonProperty("attendees")
    private List<Attendee> attendees = null;
    @JsonProperty("hangoutLink")
    private String hangoutLink;
    @JsonProperty("source")
    private Source source;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("conferenceData")
    private ConferenceData conferenceData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("organizer")
    public Organizer getOrganizer() {
        return organizer;
    }

    @JsonProperty("organizer")
    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    @JsonProperty("start")
    public Start getStart() {
        return start;
    }

    @JsonProperty("start")
    public void setStart(Start start) {
        this.start = start;
    }

    @JsonProperty("end")
    public End getEnd() {
        return end;
    }

    @JsonProperty("end")
    public void setEnd(End end) {
        this.end = end;
    }

    @JsonProperty("attendees")
    public List<Attendee> getAttendees() {
        return attendees;
    }

    @JsonProperty("attendees")
    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }

    @JsonProperty("hangoutLink")
    public String getHangoutLink() {
        return hangoutLink;
    }

    @JsonProperty("hangoutLink")
    public void setHangoutLink(String hangoutLink) {
        this.hangoutLink = hangoutLink;
    }

    @JsonProperty("source")
    public Source getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(Source source) {
        this.source = source;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("conferenceData")
    public ConferenceData getConferenceData() {
        return conferenceData;
    }

    @JsonProperty("conferenceData")
    public void setConferenceData(ConferenceData conferenceData) {
        this.conferenceData = conferenceData;
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
