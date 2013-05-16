
package org.esa.beam.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for readPixelsInt complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="readPixelsInt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="productId" type="{http://www.brockmann-consult.de/ws/beam}productId" minOccurs="0"/>
 *         &lt;element name="bandName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="w" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="h" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readPixelsInt", propOrder = {
        "productId",
        "bandName",
        "x",
        "y",
        "w",
        "h"
})
public class ReadPixelsInt {

    protected ProductId productId;
    protected String bandName;
    protected int x;
    protected int y;
    protected int w;
    protected int h;

    /**
     * Gets the value of the productId property.
     *
     * @return possible object is
     *         {@link ProductId }
     */
    public ProductId getProductId() {
        return productId;
    }

    /**
     * Sets the value of the productId property.
     *
     * @param value allowed object is
     *              {@link ProductId }
     */
    public void setProductId(ProductId value) {
        this.productId = value;
    }

    /**
     * Gets the value of the bandName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getBandName() {
        return bandName;
    }

    /**
     * Sets the value of the bandName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBandName(String value) {
        this.bandName = value;
    }

    /**
     * Gets the value of the x property.
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the value of the x property.
     */
    public void setX(int value) {
        this.x = value;
    }

    /**
     * Gets the value of the y property.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the value of the y property.
     */
    public void setY(int value) {
        this.y = value;
    }

    /**
     * Gets the value of the w property.
     */
    public int getW() {
        return w;
    }

    /**
     * Sets the value of the w property.
     */
    public void setW(int value) {
        this.w = value;
    }

    /**
     * Gets the value of the h property.
     */
    public int getH() {
        return h;
    }

    /**
     * Sets the value of the h property.
     */
    public void setH(int value) {
        this.h = value;
    }

}
