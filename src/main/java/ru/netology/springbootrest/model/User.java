package ru.netology.springbootrest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

public class User {
    @Size(min = 5, max = 10)
    @NotBlank
    private String user;
    @Size(min = 8, max = 20)
    @NotBlank
    private String password;
    private Set<Authorities> authorities = new HashSet<>();

    public User() {
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public User(String user, String password, Set<Authorities> authorities) {
        this.user = user;
        this.password = password;
        this.authorities = authorities;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authorities> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
