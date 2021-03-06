package com.approval.workflow.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Gender should not be left blank.")
    private String gender;

    @NotNull
    @NotBlank(message = "Name field is required.")
    @Size(min = 2, max = 20, message = "Name should have minimum 2 length and maximum 20.")
    private String name;

    @NotNull
    @Column(unique = true)
    @NotBlank(message = "EmailAddress field is required.")
    @Email
    private String email;

    @NotNull
    @NotBlank(message = "Password field is required.")
    private String password;

    private String role;
    private boolean enabled;
    private String image;

    @Column(length = 500)
    private String about;

    public User(String userEmail, String password) {
        this.email = userEmail;
        this.password = password;
    }
    public User() {
        // default constructor
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
