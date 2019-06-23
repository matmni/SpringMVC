package sda.workshop.MvcApp.model;

import javax.validation.constraints.Size;

public class ApplicationUserDto {

    @Size(min = 2, max = 20, message = "username length should be between 2 and 20 characters")
    private String username;
    @Size(min = 2, max = 20, message = "password length should be between 2 and 20 characters")
    private String password;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
