
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
    "data",
    "paging"
})
public class Activities {

    /**
     * The activity records returned in the list will not include the metrics object
     * (Required)
     * 
     */
    @JsonProperty("data")
    @JsonPropertyDescription("")
    private List<Datum> data = new ArrayList<Datum>();
    /**
     * This is the pagination information.This is an optional section.The next and previous sections are also optional
     * 
     */
    @JsonProperty("paging")
    @JsonPropertyDescription("")
    private Paging paging;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The activity records returned in the list will not include the metrics object
     * (Required)
     * 
     * @return
     *     The data
     */
    @JsonProperty("data")
    public List<Datum> getData() {
        return data;
    }

    /**
     * The activity records returned in the list will not include the metrics object
     * (Required)
     * 
     * @param data
     *     The data
     */
    @JsonProperty("data")
    public void setData(List<Datum> data) {
        this.data = data;
    }

    /**
     * This is the pagination information.This is an optional section.The next and previous sections are also optional
     * 
     * @return
     *     The paging
     */
    @JsonProperty("paging")
    public Paging getPaging() {
        return paging;
    }

    /**
     * This is the pagination information.This is an optional section.The next and previous sections are also optional
     * 
     * @param paging
     *     The paging
     */
    @JsonProperty("paging")
    public void setPaging(Paging paging) {
        this.paging = paging;
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
        return new HashCodeBuilder().append(data).append(paging).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Activities) == false) {
            return false;
        }
        Activities rhs = ((Activities) other);
        return new EqualsBuilder().append(data, rhs.data).append(paging, rhs.paging).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
