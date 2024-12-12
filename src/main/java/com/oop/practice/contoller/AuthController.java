package com.oop.practice.contoller;

import com.oop.practice.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Map;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Value("${LOGIN_USERNAME}")
    private String loginUsername;

    @Value("${LOGIN_PASSWORD}")
    private String loginPassword;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        if (loginUsername.equals(password) && loginPassword.equals(username)) {

            Long timeExpr = System.currentTimeMillis() + 5 * 60 * 1000;
            String token = Base64.getEncoder().encodeToString((username + ":" + timeExpr).getBytes());
            return ResponseEntity.ok().body(Map.of("token", token));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }


}
