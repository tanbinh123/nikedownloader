
package com.nikedownloader.model.json;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;


/**
 * This is the pagination information.This is an optional section.The next and previous sections are also optional
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "next",
    "previous"
})
public class Paging {

    @JsonProperty("next")
    private String next;
    @JsonProperty("previous")
    private String previous;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The next
     */
    @JsonProperty("next")
    public String getNext() {
        return next;
    }

    /**
     * 
     * @param next
     *     The next
     */
    @JsonProperty("next")
    public void setNext(String next) {
        this.next = next;
    }

    /**
     * 
     * @return
     *     The previous
     */
    @JsonProperty("previous")
    public String getPrevious() {
        return previous;
    }

    /**
     * 
     * @param previous
     *     The previous
     */
    @JsonProperty("previous")
    public void setPrevious(String previous) {
        this.previous = previous;
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
        return new HashCodeBuilder().append(next).append(previous).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Paging) == false) {
            return false;
        }
        Paging rhs = ((Paging) other);
        return new EqualsBuilder().append(next, rhs.next).append(previous, rhs.previous).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
