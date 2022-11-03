package com.quebec.cloudparking.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public
class ParkingCreateDTO {

    private String license;
    private String state;
    private String model;
    private String color;

    public
    ParkingCreateDTO (String id, String license, String state, String model, String color) {
        this.license = license;
        this.state = state;
        this.model = model;
        this.color = color;
    }

    public
    ParkingCreateDTO ( ) {
    }

    public
    String getLicense ( ) {
        return license;
    }

    public
    void setLicense (String license) {
        this.license = license;
    }

    public
    String getState ( ) {
        return state;
    }

    public
    void setState (String state) {
        this.state = state;
    }

    public
    String getModel ( ) {
        return model;
    }

    public
    void setModel (String model) {
        this.model = model;
    }

    public
    String getColor ( ) {
        return color;
    }

    public
    void setColor (String color) {
        this.color = color;
    }

}
