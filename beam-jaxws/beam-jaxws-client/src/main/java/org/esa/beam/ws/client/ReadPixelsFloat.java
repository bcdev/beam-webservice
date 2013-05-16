
package org.esa.beam.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for readPixelsFloat complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="readPixelsFloat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.brockmann-consult.de/ws/beam}productId" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="arg3" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="arg4" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="arg5" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readPixelsFloat", propOrder = {
        "arg0",
        "arg1",
        "arg2",
        "arg3",
        "arg4",
        "arg5"
})
public class ReadPixelsFloat {

    protected ProductId arg0;
    protected String arg1;
    protected int arg2;
    protected int arg3;
    protected int arg4;
    protected int arg5;

    /**
     * Gets the value of the arg0 property.
     *
     * @return possible object is
     *         {@link ProductId }
     */
    public ProductId getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     *
     * @param value allowed object is
     *              {@link ProductId }
     */
    public void setArg0(ProductId value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setArg1(String value) {
        this.arg1 = value;
    }

    /**
     * Gets the value of the arg2 property.
     */
    public int getArg2() {
        return arg2;
    }

    /**
     * Sets the value of the arg2 property.
     */
    public void setArg2(int value) {
        this.arg2 = value;
    }

    /**
     * Gets the value of the arg3 property.
     */
    public int getArg3() {
        return arg3;
    }

    /**
     * Sets the value of the arg3 property.
     */
    public void setArg3(int value) {
        this.arg3 = value;
    }

    /**
     * Gets the value of the arg4 property.
     */
    public int getArg4() {
        return arg4;
    }

    /**
     * Sets the value of the arg4 property.
     */
    public void setArg4(int value) {
        this.arg4 = value;
    }

    /**
     * Gets the value of the arg5 property.
     */
    public int getArg5() {
        return arg5;
    }

    /**
     * Sets the value of the arg5 property.
     */
    public void setArg5(int value) {
        this.arg5 = value;
    }

}
