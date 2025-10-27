package com.GestionTicket.Controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionTicket.DTO.LoginRequest;
import com.GestionTicket.Entitie.Compte;
import com.GestionTicket.Service.AuthService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

//	
//	private  	JWTUils jwtUils;
//
//    @Autowired 
//    AuthService authService;
//    
//    @GetMapping("/user/{email}")
//    public ResponseEntity<Compte> findCompteByEmail(@PathVariable String email) {
//        Compte compte = authService.findByEmail(email);
//    	if (compte == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(compte);
//    }
//    
//    
//    @PostMapping("/auth/register")
//    public ResponseEntity<LoginRequest> regeister(@RequestBody LoginRequest req){
//    	
//        return ResponseEntity.ok(authService.register(req));
//    }
//    
//    @PostMapping("/auth/login")
//    public ResponseEntity<LoginRequest> login(@RequestBody LoginRequest req){
//    	System.out.println("Received login request: " + req.getEmail());
//    	System.out.println("Received login request: " + req);
//        System.out.println("Email: " + req.getEmail());
//        System.out.println("Password: " + req.getMotDePasse());
//        return ResponseEntity.ok(authService.login(req));
//    }
//    
//    
//    @GetMapping("/auth/utilisateur")
//    public ResponseEntity<Compte> getUtilisateur() {
//        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || !authentication.isAuthenticated()) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
//        }
//        
//        String username = authentication.getName();
//        Compte compte = authService.getCompteByEmail(username); 
//        
//        if (compte == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//        
//        return ResponseEntity.ok(compte);
//    }
//
//    
//    @PostMapping("/refresh")
//    public ResponseEntity<LoginRequest> refreshToken(@RequestBody LoginRequest req){
//        return ResponseEntity.ok(authService.refreshToken(req));
//    }
//    
//   /* @GetMapping("/admin/get-all-users")
//    public ResponseEntity<LoginRequest> getAllUsers(){
//        return ResponseEntity.ok(authService.getAllUsers());
//
//    }*/
//
//  /*  @GetMapping("/auth/utilisateur")
//    public ResponseEntity<Compte> getCurrentUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = authentication.getName();
//        Compte compte = authService.findByEmail(email);
//        if (compte == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(compte);
//    }*/
//    
//    
//    @PostMapping(value = "/authenticate")
//	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)
//			throws Exception {
//
//		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//
//		final UserDetails userDetails = AuthService
//				.loadUserByUsername(authenticationRequest.getUsername());
//
//		final String token = jwtUils.generateToken(userDetails);
//
//		return ResponseEntity.ok(new LoginRequest(token));
//		
//	}
    
}
