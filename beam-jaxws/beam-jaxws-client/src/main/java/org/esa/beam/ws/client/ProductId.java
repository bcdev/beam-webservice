
package org.esa.beam.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productId complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="productId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rasterHeight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rasterWidth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productId", propOrder = {
        "location",
        "rasterHeight",
        "rasterWidth"
})
public class ProductId {

    protected String location;
    protected int rasterHeight;
    protected int rasterWidth;

    /**
     * Gets the value of the location property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the rasterHeight property.
     */
    public int getRasterHeight() {
        return rasterHeight;
    }

    /**
     * Sets the value of the rasterHeight property.
     */
    public void setRasterHeight(int value) {
        this.rasterHeight = value;
    }

    /**
     * Gets the value of the rasterWidth property.
     */
    public int getRasterWidth() {
        return rasterWidth;
    }

    /**
     * Sets the value of the rasterWidth property.
     */
    public void setRasterWidth(int value) {
        this.rasterWidth = value;
    }

}
