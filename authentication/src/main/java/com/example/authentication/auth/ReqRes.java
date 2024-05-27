package com.example.authentication.auth;

import com.example.authentication.user.Role;
import com.example.authentication.user.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRes {

    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String firstname;
    private String lastname;
    private Role role;
    private String email;
    private String password;
    private Utilisateur utilisateur;
    private List<Utilisateur> usersList;

}
