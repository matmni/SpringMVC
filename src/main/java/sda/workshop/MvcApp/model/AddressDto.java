package sda.workshop.MvcApp.model;

public class AddressDto {

    private String city;

    public AddressDto(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
