package sda.workshop.MvcApp.model;

import java.util.Date;

//User Data Transfer Object
public class UserDto {

    private String name;
    private String surname;
    private Date joinDate;
    private AddressDto addressDto;

    public UserDto() {
        addressDto = new AddressDto("Krakow");
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }
}
