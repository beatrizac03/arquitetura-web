package com.api.authjwt.DTOs;

public class UsuarioResponseDto {
    private String username;
    private String role;

    public UsuarioResponseDto() {
    }

    public UsuarioResponseDto(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
