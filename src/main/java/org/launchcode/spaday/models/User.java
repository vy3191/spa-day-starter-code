package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotEmpty(message = "Username is required.")
    @Size(min = 3, max = 12, message = "User name mut be between 3 and 12 characters long")
    private String username;

    @Email(message = "Please provide a valid email")
    private String email;

    @NotEmpty(message = "Password is required.")
    @Size(min = 6, message = "Passwords must be at least 6 characters long")
    private String password;

    @NotNull(message = "Passwords do not match.")
    private String verifyPassword;

    public User() {
    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword(){
        if ((this.password != null || this.verifyPassword != null) && !this.password.equals(this.verifyPassword)){
            this.verifyPassword = null;
        }
    }
}
