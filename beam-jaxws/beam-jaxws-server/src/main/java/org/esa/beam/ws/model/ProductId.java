package org.esa.beam.ws.model;

import javax.jws.WebMethod;

/**
 * @author Norman Fomferra
 */
public class ProductId {
    private int rasterWidth;
    private int rasterHeight;
    private String location;

    public ProductId() {
    }

    public ProductId(int rasterWidth, int rasterHeight, String location) {
        this.rasterWidth = rasterWidth;
        this.rasterHeight = rasterHeight;
        this.location = location;
    }

    @WebMethod
    public int getRasterWidth() {
        return rasterWidth;
    }

    @WebMethod
    public int getRasterHeight() {
        return rasterHeight;
    }

    @WebMethod
    public String getLocation() {
        return location;
    }

    @WebMethod
    public void setLocation(String location) {
        this.location = location;
    }

    @WebMethod
    public void setRasterHeight(int rasterHeight) {
        this.rasterHeight = rasterHeight;
    }

    @WebMethod
    public void setRasterWidth(int rasterWidth) {
        this.rasterWidth = rasterWidth;
    }
}
