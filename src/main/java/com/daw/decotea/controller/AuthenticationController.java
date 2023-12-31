//package com.daw.decotea.controller;
//
//import com.daw.decotea.config.JwtUtils;
//import com.daw.decotea.model.JWTRequest;
//import com.daw.decotea.model.JwtResponse;
//import com.daw.decotea.model.User;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//
//@RestController
//@CrossOrigin("*")
//public class AuthenticationController {
//
//    private AuthenticationManager authenticationManager;
//
//    private UserDetailsService userDetailsService;
//
//    private JwtUtils jwtUtils;
//
//    @PostMapping("/generate-token")
//    public ResponseEntity<?> generarToken(@RequestBody JWTRequest jwtRequest) throws Exception {
//        try{
//            autenticar(jwtRequest.getUsername(),jwtRequest.getPassword());
//        }catch (Exception exception){
//            exception.printStackTrace();
//            throw new Exception("Usuario no encontrado");
//        }
//
//        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
//        String token = this.jwtUtils.generateToken(userDetails);
//        return ResponseEntity.ok(new JwtResponse(token));
//    }
//
//    private void autenticar(String username,String password) throws Exception {
//        try{
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
//        }catch (DisabledException exception){
//            throw  new Exception("USUARIO DESHABILITADO " + exception.getMessage());
//        }catch (BadCredentialsException e){
//            throw  new Exception("Credenciales invalidas " + e.getMessage());
//        }
//    }
//
//    @GetMapping("/actual-usuario")
//    public User obtenerUsuarioActual(Principal principal){
//        return (User) this.userDetailsService.loadUserByUsername(principal.getName());
//    }
//}
