package com.griddynamics.qa.vikta.uitesting.sample.elements;

public class Address {
protected String street;
    protected String additionalStreetInfo;
    protected String city;
    protected String region;
    protected String postalCode;
    protected String addressNickname;

    public Address(String street, String additionalStreetInfo, String city, String region, String postalCode, String addressNickname) {
        this.street = street;
        this.additionalStreetInfo = additionalStreetInfo;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.addressNickname = addressNickname;
    }

    public Address() {

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalStreetInfo() {
        return additionalStreetInfo;
    }

    public void setAdditionalStreetInfo(String additionalStreetInfo) {
        this.additionalStreetInfo = additionalStreetInfo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddressNickname() {
        return addressNickname;
    }

    public void setAddressNickname(String addressNickname) {
        this.addressNickname = addressNickname;
    }
}
