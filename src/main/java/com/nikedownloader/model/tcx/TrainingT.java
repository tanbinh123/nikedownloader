//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.09 at 08:48:53 AM CEST 
//


package com.nikedownloader.model.tcx;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Training_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Training_t"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="QuickWorkoutResults" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}QuickWorkout_t" minOccurs="0"/&gt;
 *         &lt;element name="Plan" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Plan_t" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="VirtualPartner" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Training_t", propOrder = {
    "quickWorkoutResults",
    "plan"
})
public class TrainingT {

    @XmlElement(name = "QuickWorkoutResults")
    protected QuickWorkoutT quickWorkoutResults;
    @XmlElement(name = "Plan")
    protected PlanT plan;
    @XmlAttribute(name = "VirtualPartner", required = true)
    protected boolean virtualPartner;

    /**
     * Gets the value of the quickWorkoutResults property.
     *
     * @return
     *     possible object is
     *     {@link QuickWorkoutT }
     *
     */
    public QuickWorkoutT getQuickWorkoutResults() {
        return quickWorkoutResults;
    }

    /**
     * Sets the value of the quickWorkoutResults property.
     *
     * @param value
     *     allowed object is
     *     {@link QuickWorkoutT }
     *
     */
    public void setQuickWorkoutResults(QuickWorkoutT value) {
        this.quickWorkoutResults = value;
    }

    /**
     * Gets the value of the plan property.
     * 
     * @return
     *     possible object is
     *     {@link PlanT }
     *     
     */
    public PlanT getPlan() {
        return plan;
    }

    /**
     * Sets the value of the plan property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlanT }
     *     
     */
    public void setPlan(PlanT value) {
        this.plan = value;
    }

    /**
     * Gets the value of the virtualPartner property.
     * 
     */
    public boolean isVirtualPartner() {
        return virtualPartner;
    }

    /**
     * Sets the value of the virtualPartner property.
     * 
     */
    public void setVirtualPartner(boolean value) {
        this.virtualPartner = value;
    }

}
