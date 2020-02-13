package ua.testing.Model.Entities;

import ua.testing.View.View;

public class Address {
    private String index;
    private String city;
    private String street;
    private String houseNumber;
    private String flatNumber;

    public Address(String index, String city, String street, String houseNumber, String flatNumber) {
        this.index = index;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }

    public String getFullAddress() {
        return View.concatenatingStrings(index, View.COMMA_SIGN, View.SPACE_SIGN,
                                        city, View.COMMA_SIGN, View.SPACE_SIGN,
                                        street, View.COMMA_SIGN, View.SPACE_SIGN,
                                        houseNumber, View.COMMA_SIGN, View.SPACE_SIGN,
                                        flatNumber, View.POINT_SIGN);
    }

}
