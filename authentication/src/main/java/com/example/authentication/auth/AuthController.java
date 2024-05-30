package com.example.authentication.auth;

import com.example.authentication.services.AuthService;
import com.example.authentication.user.Utilisateur;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;


@RestController

@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

//    @PostMapping("/register")
//    public ResponseEntity<AuthenticationResponse> register(
//            @RequestBody RegisterRequest request
//    ) {
//        return ResponseEntity.ok(service.register(request));
//    }
//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> authenticate(
//            @RequestBody AuthenticationRequest request
//    ) {
//        return ResponseEntity.ok(service.authenticate(request));
//    }

//    @PostMapping("/refresh-token")
//    public void refreshToken(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws IOException {
//        service.refreshToken(request, response);
//    }

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//    @RestController
//    public class UserManagementController {
//        @Autowired
//        private UsersManagementService usersManagementService;
//
        @PostMapping("/api/v1/auth/register")
        public ResponseEntity<ReqRes> register(@RequestBody ReqRes reg){
            return ResponseEntity.ok(service.register(reg));
        }

        @PostMapping("/api/v1/auth/login")
        public ResponseEntity<ReqRes> login(@RequestBody AuthenticationRequest req){
            return ResponseEntity.ok(service.login(req));
        }

//        @PostMapping("/api/v1/auth/refresh")
//        public ResponseEntity<ReqRes> refreshToken(@RequestBody ReqRes req){
//            return ResponseEntity.ok(service.refreshToken(req));
//        }

        @GetMapping("api/v1/admin/getAllUsers")
        public ResponseEntity<ReqRes> getAllUsers(){
            return ResponseEntity.ok(service.getAllUsers());

        }

        @GetMapping("api/v1/admin/getUsers/{userId}")
        public ResponseEntity<ReqRes> getUSerByID(@PathVariable Integer userId){
            return ResponseEntity.ok(service.getUsersById(userId));

        }

        @PutMapping("api/v1/admin/update/{userId}")
        public ResponseEntity<ReqRes> updateUser(@PathVariable Integer userId, @RequestBody Utilisateur reqres){
            return ResponseEntity.ok(service.updateUser(userId, reqres));
        }

        @GetMapping("api/v1/adminuser/getProfile")
        public ResponseEntity<ReqRes> getMyProfile(){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String email = authentication.getName();
            ReqRes response = service.getMyInfo(email);
            return  ResponseEntity.status(response.getStatusCode()).body(response);
        }

        @DeleteMapping("api/v1/admin/delete/{userId}")
        public ResponseEntity<ReqRes> deleteUSer(@PathVariable Integer userId){
            return ResponseEntity.ok(service.deleteUser(userId));
        }
}
