package com.codefestnepal.dotconnect.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AgencyLoginDto {
    @NotBlank
    @NotNull
    private String userName;
    @NotNull
    @NotBlank
    private String password;

    public String getUserName() {
        return userName;
    }

    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
