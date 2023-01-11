package org.example.models;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;

//@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;
    private String username;
    private String email;
    private String password;
    private String role;
    public User(){}
    public User(int userid,String username, String email, String password, String role) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getUserid() {
        return userid;
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
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }

    public String toString(@NotEmpty String username) {
        return "User{" +
                "userid=" + userid +
                ", username='" + this.username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + role + '\'' +
                '}';
    }
}
