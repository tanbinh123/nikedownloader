
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


/**
 * The metrics object with the metric types and the corresponding measurements.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "intervalUnit",
    "intervalMetric",
    "metricType",
    "values"
})
public class Metric {

    /**
     * The unit of the time interval for an activity. WIll only accept sec
     * (Required)
     * 
     */
    @JsonProperty("intervalUnit")
    @JsonPropertyDescription("")
    private Metric.IntervalUnit intervalUnit;
    /**
     * The time interval value in seconds
     * (Required)
     *
     */
    @JsonProperty("intervalMetric")
    @JsonPropertyDescription("")
    private Metric.IntervalMetric intervalMetric;
    /**
     * Metric metadata describing its type.
     *
     */
    @JsonProperty("metricType")
    @JsonPropertyDescription("")
    private Metric.MetricType metricType;
    @JsonProperty("values")
    private List<String> values = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The unit of the time interval for an activity. WIll only accept sec
     * (Required)
     *
     * @return
     *     The intervalUnit
     */
    @JsonProperty("intervalUnit")
    public Metric.IntervalUnit getIntervalUnit() {
        return intervalUnit;
    }

    /**
     * The unit of the time interval for an activity. WIll only accept sec
     * (Required)
     *
     * @param intervalUnit
     *     The intervalUnit
     */
    @JsonProperty("intervalUnit")
    public void setIntervalUnit(Metric.IntervalUnit intervalUnit) {
        this.intervalUnit = intervalUnit;
    }

    /**
     * The time interval value in seconds
     * (Required)
     *
     * @return
     *     The intervalMetric
     */
    @JsonProperty("intervalMetric")
    public Metric.IntervalMetric getIntervalMetric() {
        return intervalMetric;
    }

    /**
     * The time interval value in seconds
     * (Required)
     *
     * @param intervalMetric
     *     The intervalMetric
     */
    @JsonProperty("intervalMetric")
    public void setIntervalMetric(Metric.IntervalMetric intervalMetric) {
        this.intervalMetric = intervalMetric;
    }

    /**
     * Metric metadata describing its type.
     *
     * @return
     *     The metricType
     */
    @JsonProperty("metricType")
    public Metric.MetricType getMetricType() {
        return metricType;
    }

    /**
     * Metric metadata describing its type.
     *
     * @param metricType
     *     The metricType
     */
    @JsonProperty("metricType")
    public void setMetricType(Metric.MetricType metricType) {
        this.metricType = metricType;
    }

    /**
     *
     * @return
     *     The values
     */
    @JsonProperty("values")
    public List<String> getValues() {
        return values;
    }

    /**
     *
     * @param values
     *     The values
     */
    @JsonProperty("values")
    public void setValues(List<String> values) {
        this.values = values;
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
        return new HashCodeBuilder().append(intervalUnit).append(intervalMetric).append(metricType).append(values).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Metric) == false) {
            return false;
        }
        Metric rhs = ((Metric) other);
        return new EqualsBuilder().append(intervalUnit, rhs.intervalUnit).append(intervalMetric, rhs.intervalMetric).append(metricType, rhs.metricType).append(values, rhs.values).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public enum IntervalMetric {

        _1("1"),
        _5("5"),
        _10("10");
        private final String value;
        private final static Map<String, Metric.IntervalMetric> CONSTANTS = new HashMap<String, Metric.IntervalMetric>();

        static {
            for (Metric.IntervalMetric c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private IntervalMetric(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static Metric.IntervalMetric fromValue(String value) {
            Metric.IntervalMetric constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("org.jsonschema2pojo")
    public enum IntervalUnit {

        SEC("SEC"),
        MIN("MIN");
        private final String value;
        private final static Map<String, Metric.IntervalUnit> CONSTANTS = new HashMap<String, Metric.IntervalUnit>();

        static {
            for (Metric.IntervalUnit c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private IntervalUnit(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static Metric.IntervalUnit fromValue(String value) {
            Metric.IntervalUnit constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("org.jsonschema2pojo")
    public enum MetricType {

        CALORIES("CALORIES"),
        DISTANCE("DISTANCE"),
        ELEVATION("ELEVATION"),
        GPSSIGNALSTRENGTH("GPSSIGNALSTRENGTH"),
        GRADE("GRADE"),
        FUEL("FUEL"),
        LATITUDE("LATITUDE"),
        LONGITUDE("LONGITUDE"),
        SPEED("SPEED"),
        STEPS("STEPS"),
        WATTS("WATTS"),
        PACE("PACE"),
        WIND_SPEED("WIND_SPEED"),
        HEARTRATE("HEARTRATE");
        private final String value;
        private final static Map<String, Metric.MetricType> CONSTANTS = new HashMap<String, Metric.MetricType>();

        static {
            for (Metric.MetricType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private MetricType(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static Metric.MetricType fromValue(String value) {
            Metric.MetricType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
