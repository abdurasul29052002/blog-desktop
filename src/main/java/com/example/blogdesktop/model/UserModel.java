package com.example.blogdesktop.model;

import com.example.blogdesktop.model.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private Long id;

    private String fullName;

    private String username;

    private String password;

    private Roles roles;

    private String bio;

    private List<UserModel> followers;

    private List<UserModel> follows;

    private List<UserModel> friends;

    private Integer followersCount;

    private Integer followsCount;

    private Integer friendsCount;

    public UserModel(String username, String password){
        this.username = username;
        this.password = password;
    }
    public UserModel(String fullName, String username, String password){
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }
}

