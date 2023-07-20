package com.SecuritywithDB.MyEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

    @Id
    private String username;
    private String password;

    @Column(name = "enabled", columnDefinition = "TINYINT(1)")
    private boolean enabled;

    // Constructors, getters, setters, and other methods (if any)

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    // Constructors, getters, setters, and other methods (if any)
}
