package org.esa.beam.ws.model;

import javax.jws.WebMethod;

/**
 * @author Norman Fomferra
 */
public class BandId {
    private String name;
    private String unit;
    private double wavelength;

    public BandId() {
    }

    public BandId(String name, String unit, double wavelength) {
        this.name = name;
        this.unit = unit;
        this.wavelength = wavelength;
    }

    @WebMethod
    public String getName() {
        return name;
    }

    @WebMethod
    public String getUnit() {
        return unit;
    }

    @WebMethod
    public double getWavelength() {
        return wavelength;
    }

    @WebMethod
    public void setName(String name) {
        this.name = name;
    }

    @WebMethod
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @WebMethod
    public void setWavelength(double wavelength) {
        this.wavelength = wavelength;
    }
}
