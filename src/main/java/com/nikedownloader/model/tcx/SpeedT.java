//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.09 at 08:48:53 AM CEST 
//


package com.nikedownloader.model.tcx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Speed_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Speed_t"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Target_t"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SpeedZone" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Zone_t"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Speed_t", propOrder = {
    "speedZone"
})
public class SpeedT
    extends TargetT
{

    @XmlElement(name = "SpeedZone", required = true)
    protected ZoneT speedZone;

    /**
     * Gets the value of the speedZone property.
     *
     * @return
     *     possible object is
     *     {@link ZoneT }
     *
     */
    public ZoneT getSpeedZone() {
        return speedZone;
    }

    /**
     * Sets the value of the speedZone property.
     *
     * @param value
     *     allowed object is
     *     {@link ZoneT }
     *     
     */
    public void setSpeedZone(ZoneT value) {
        this.speedZone = value;
    }

}
