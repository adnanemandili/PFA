package com.example.authentication.services;


import com.example.authentication.auth.AuthenticationRequest;
import com.example.authentication.auth.ReqRes;
import com.example.authentication.user.Utilisateur;
import com.example.authentication.user.UserReposetory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserReposetory repository;
//    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public ReqRes register(ReqRes registrationRequest){
        ReqRes resp = new ReqRes();

        try {
            Utilisateur ourUtilisateur = new Utilisateur();
            ourUtilisateur.setEmail(registrationRequest.getEmail());
            ourUtilisateur.setFirstname(registrationRequest.getFirstname());
            ourUtilisateur.setRole(registrationRequest.getRole());
            ourUtilisateur.setLastname(registrationRequest.getLastname());
            ourUtilisateur.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            Utilisateur ourUsersResult = repository.save(ourUtilisateur);
            if (ourUsersResult.getId()>0) {
                resp.setUtilisateur((ourUsersResult));
                resp.setMessage("User Saved Successfully");
                resp.setStatusCode(200);
            }

        }catch (Exception e){
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }


    public ReqRes login(AuthenticationRequest loginRequest){
        ReqRes response = new ReqRes();
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword()));
            var user = repository.findByEmail(loginRequest.getEmail()).orElseThrow();
            var jwt = jwtService.generateToken(user);
//            var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRole(user.getRole());
            response.setRefreshToken(null);
            response.setExpirationTime("24Hrs");
            response.setMessage("Successfully Logged In");

        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }





    public ReqRes refreshToken(ReqRes refreshTokenReqiest){
        ReqRes response = new ReqRes();
        try{
            String ourEmail = jwtService.extractUsername(refreshTokenReqiest.getToken());
            Utilisateur users = repository.findByEmail(ourEmail).orElseThrow();
            if (jwtService.isTokenValid(refreshTokenReqiest.getToken(), users)) {
                var jwt = jwtService.generateToken(users);
                response.setStatusCode(200);
                response.setToken(jwt);
                response.setRefreshToken(refreshTokenReqiest.getToken());
                response.setExpirationTime("24Hr");
                response.setMessage("Successfully Refreshed Token");
            }
            response.setStatusCode(200);
            return response;

        }catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
            return response;
        }
    }


    public ReqRes getAllUsers() {
        ReqRes reqRes = new ReqRes();

        try {
            List<Utilisateur> result = repository.findAll();
            if (!result.isEmpty()) {
                reqRes.setUsersList(result);
                reqRes.setStatusCode(200);
                reqRes.setMessage("Successful");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("No users found");
            }
            return reqRes;
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred: " + e.getMessage());
            return reqRes;
        }
    }


    public ReqRes getUsersById(Integer id) {
        ReqRes reqRes = new ReqRes();
        try {
            Utilisateur usersById = repository.findById(id).orElseThrow(() -> new RuntimeException("User Not found"));
            reqRes.setUtilisateur(usersById);
            reqRes.setStatusCode(200);
            reqRes.setMessage("Users with id '" + id + "' found successfully");
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred: " + e.getMessage());
        }
        return reqRes;
    }


    public ReqRes deleteUser(Integer userId) {
        ReqRes reqRes = new ReqRes();
        try {
            Optional<Utilisateur> userOptional = repository.findById(userId);
            if (userOptional.isPresent()) {
                repository.deleteById(userId);
                reqRes.setStatusCode(200);
                reqRes.setMessage("User deleted successfully");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for deletion");
            }
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while deleting user: " + e.getMessage());
        }
        return reqRes;
    }

    public ReqRes updateUser(Integer userId, Utilisateur updatedUtilisateur) {
        ReqRes reqRes = new ReqRes();
        try {
            Optional<Utilisateur> userOptional = repository.findById(userId);
            if (userOptional.isPresent()) {
                Utilisateur existingUtilisateur = userOptional.get();
                existingUtilisateur.setEmail(updatedUtilisateur.getEmail());
                existingUtilisateur.setLastname(updatedUtilisateur.getLastname());
                existingUtilisateur.setFirstname(updatedUtilisateur.getFirstname());
                existingUtilisateur.setRole(updatedUtilisateur.getRole());

                // Check if password is present in the request
                if (updatedUtilisateur.getPassword() != null && !updatedUtilisateur.getPassword().isEmpty()) {
                    // Encode the password and update it
                    existingUtilisateur.setPassword(passwordEncoder.encode(updatedUtilisateur.getPassword()));
                }

                Utilisateur savedUtilisateur = repository.save(existingUtilisateur);
                reqRes.setUtilisateur(savedUtilisateur);
                reqRes.setStatusCode(200);
                reqRes.setMessage("User updated successfully");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for update");
            }
        } catch (Exception e) {
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while updating user: " + e.getMessage());
        }
        return reqRes;
    }


    public ReqRes getMyInfo(String email){
        ReqRes reqRes = new ReqRes();
        try {
            Optional<Utilisateur> userOptional = repository.findByEmail(email);
            if (userOptional.isPresent()) {
                reqRes.setUtilisateur(userOptional.get());
                reqRes.setStatusCode(200);
                reqRes.setMessage("successful");
            } else {
                reqRes.setStatusCode(404);
                reqRes.setMessage("User not found for update");
            }

        }catch (Exception e){
            reqRes.setStatusCode(500);
            reqRes.setMessage("Error occurred while getting user info: " + e.getMessage());
        }
        return reqRes;

    }
}