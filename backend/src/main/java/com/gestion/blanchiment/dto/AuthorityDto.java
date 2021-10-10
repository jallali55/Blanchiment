package com.gestion.blanchiment.dto;


public class AuthorityDto {
    private String role;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public AuthorityDto(Long id, String role) {
        this.role = role;
    }
}
