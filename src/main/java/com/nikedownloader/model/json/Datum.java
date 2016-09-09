
package com.nikedownloader.model.json;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "links",
    "activityId",
    "deviceType",
    "startTime",
    "activityTimeZone",
    "status",
    "tags",
    "metricSummary",
    "activityType",
    "metrics",
    "isGpsActivity"
})
public class Datum {

    @JsonProperty("links")
    private List<Link> links = new ArrayList<Link>();
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("activityId")
    private String activityId;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("deviceType")
    private String deviceType;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("activityTimeZone")
    private String activityTimeZone;
    @JsonProperty("status")
    private String status;
    @JsonProperty("tags")
    private List<Tag> tags = new ArrayList<Tag>();
    /**
     * A summary of the calculated metrics. All values are parseable to numbers.
     *
     */
    @JsonProperty("metricSummary")
    @JsonPropertyDescription("")
    private MetricSummary metricSummary;
    /**
     * Activity metadata describing its type.
     *
     */
    @JsonProperty("activityType")
    @JsonPropertyDescription("")
    private String activityType;
    @JsonProperty("metrics")
    private List<Metric> metrics = new ArrayList<Metric>();
    @JsonProperty("isGpsActivity")
    private Boolean isGpsActivity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *     The links
     */
    @JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    /**
     *
     * @param links
     *     The links
     */
    @JsonProperty("links")
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    /**
     *
     * (Required)
     *
     * @return
     *     The activityId
     */
    @JsonProperty("activityId")
    public String getActivityId() {
        return activityId;
    }

    /**
     *
     * (Required)
     *
     * @param activityId
     *     The activityId
     */
    @JsonProperty("activityId")
    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    /**
     *
     * (Required)
     *
     * @return
     *     The deviceType
     */
    @JsonProperty("deviceType")
    public String getDeviceType() {
        return deviceType;
    }

    /**
     *
     * (Required)
     *
     * @param deviceType
     *     The deviceType
     */
    @JsonProperty("deviceType")
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     *
     * (Required)
     *
     * @return
     *     The startTime
     */
    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    /**
     *
     * (Required)
     *
     * @param startTime
     *     The startTime
     */
    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     *
     * @return
     *     The activityTimeZone
     */
    @JsonProperty("activityTimeZone")
    public String getActivityTimeZone() {
        return activityTimeZone;
    }

    /**
     *
     * @param activityTimeZone
     *     The activityTimeZone
     */
    @JsonProperty("activityTimeZone")
    public void setActivityTimeZone(String activityTimeZone) {
        this.activityTimeZone = activityTimeZone;
    }

    /**
     *
     * @return
     *     The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     *     The tags
     */
    @JsonProperty("tags")
    public List<Tag> getTags() {
        return tags;
    }

    /**
     *
     * @param tags
     *     The tags
     */
    @JsonProperty("tags")
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * A summary of the calculated metrics. All values are parseable to numbers.
     *
     * @return
     *     The metricSummary
     */
    @JsonProperty("metricSummary")
    public MetricSummary getMetricSummary() {
        return metricSummary;
    }

    /**
     * A summary of the calculated metrics. All values are parseable to numbers.
     *
     * @param metricSummary
     *     The metricSummary
     */
    @JsonProperty("metricSummary")
    public void setMetricSummary(MetricSummary metricSummary) {
        this.metricSummary = metricSummary;
    }

    /**
     * Activity metadata describing its type.
     *
     * @return
     *     The activityType
     */
    @JsonProperty("activityType")
    public String getActivityType() {
        return activityType;
    }

    /**
     * Activity metadata describing its type.
     *
     * @param activityType
     *     The activityType
     */
    @JsonProperty("activityType")
    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    /**
     *
     * @return
     *     The metrics
     */
    @JsonProperty("metrics")
    public List<Metric> getMetrics() {
        return metrics;
    }

    /**
     * 
     * @param metrics
     *     The metrics
     */
    @JsonProperty("metrics")
    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }

    /**
     * 
     * @return
     *     The isGpsActivity
     */
    @JsonProperty("isGpsActivity")
    public Boolean getIsGpsActivity() {
        return isGpsActivity;
    }

    /**
     * 
     * @param isGpsActivity
     *     The isGpsActivity
     */
    @JsonProperty("isGpsActivity")
    public void setIsGpsActivity(Boolean isGpsActivity) {
        this.isGpsActivity = isGpsActivity;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(links).append(activityId).append(deviceType).append(startTime).append(activityTimeZone).append(status).append(tags).append(metricSummary).append(activityType).append(metrics).append(isGpsActivity).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Datum) == false) {
            return false;
        }
        Datum rhs = ((Datum) other);
        return new EqualsBuilder().append(links, rhs.links).append(activityId, rhs.activityId).append(deviceType, rhs.deviceType).append(startTime, rhs.startTime).append(activityTimeZone, rhs.activityTimeZone).append(status, rhs.status).append(tags, rhs.tags).append(metricSummary, rhs.metricSummary).append(activityType, rhs.activityType).append(metrics, rhs.metrics).append(isGpsActivity, rhs.isGpsActivity).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
