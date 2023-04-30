package com.builderAPI.builder.security;

import com.builderAPI.builder.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    private AuthenticationManager authenticationManager;

    private JwtTokenUtil jwtTokenUtil;

    private UserService userService;

    //NEED TO DEFINE custom clases 'LoginRequest/Response'



    //using the AuthenticationManager to authenticate the user and the JwtTokenUtil to generate and validate JWT tokens.
    //using a UserService to load the user's details for authentication purposes

    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        final UserDetails userDetails = userService.loadUserByUsername(loginRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(token));



    }

    public ResponseEntity<Void> logout(HttpServletRequest request) {
        String token = jwtTokenUtil.getTokenFromRequest(request);
        jwtTokenUtil.invalidateToken(token);
        return ResponseEntity.ok().build();
    }



}
