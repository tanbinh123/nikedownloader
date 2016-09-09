
package com.nikedownloader.model.json;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;


/**
 * A summary of the calculated metrics. All values are parseable to numbers.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "fuel",
    "distance",
    "duration",
    "calories",
    "steps"
})
public class MetricSummary {

    @JsonProperty("fuel")
    private String fuel;
    @JsonProperty("distance")
    private String distance;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("calories")
    private String calories;
    @JsonProperty("steps")
    private String steps;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The fuel
     */
    @JsonProperty("fuel")
    public String getFuel() {
        return fuel;
    }

    /**
     * 
     * @param fuel
     *     The fuel
     */
    @JsonProperty("fuel")
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    /**
     * 
     * @return
     *     The distance
     */
    @JsonProperty("distance")
    public String getDistance() {
        return distance;
    }

    /**
     * 
     * @param distance
     *     The distance
     */
    @JsonProperty("distance")
    public void setDistance(String distance) {
        this.distance = distance;
    }

    /**
     * 
     * @return
     *     The duration
     */
    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    /**
     * 
     * @param duration
     *     The duration
     */
    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * 
     * @return
     *     The calories
     */
    @JsonProperty("calories")
    public String getCalories() {
        return calories;
    }

    /**
     * 
     * @param calories
     *     The calories
     */
    @JsonProperty("calories")
    public void setCalories(String calories) {
        this.calories = calories;
    }

    /**
     * 
     * @return
     *     The steps
     */
    @JsonProperty("steps")
    public String getSteps() {
        return steps;
    }

    /**
     * 
     * @param steps
     *     The steps
     */
    @JsonProperty("steps")
    public void setSteps(String steps) {
        this.steps = steps;
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
        return new HashCodeBuilder().append(fuel).append(distance).append(duration).append(calories).append(steps).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MetricSummary) == false) {
            return false;
        }
        MetricSummary rhs = ((MetricSummary) other);
        return new EqualsBuilder().append(fuel, rhs.fuel).append(distance, rhs.distance).append(duration, rhs.duration).append(calories, rhs.calories).append(steps, rhs.steps).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
