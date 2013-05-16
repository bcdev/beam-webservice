
package org.esa.beam.ws.client;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for readPixelsFloatResponse complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="readPixelsFloatResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pixels" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readPixelsFloatResponse", propOrder = {
        "pixels"
})
public class ReadPixelsFloatResponse {

    @XmlMimeType("application/octet-stream")
    protected DataHandler pixels;

    /**
     * Gets the value of the pixels property.
     *
     * @return possible object is
     *         {@link DataHandler }
     */
    public DataHandler getPixels() {
        return pixels;
    }

    /**
     * Sets the value of the pixels property.
     *
     * @param value allowed object is
     *              {@link DataHandler }
     */
    public void setPixels(DataHandler value) {
        this.pixels = value;
    }

}
