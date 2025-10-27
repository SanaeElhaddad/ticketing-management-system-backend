package com.GestionTicket.config;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionTicket.Entitie.Compte;
import com.GestionTicket.Service.CompteService;

import org.springframework.security.core.context.SecurityContextHolder;



import java.util.Objects;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200",exposedHeaders = "token")
public class JwtAuthenticationController {

	@Autowired
	private  AuthenticationManager authenticationManager;

	@Autowired
	private  JwtTokenUtil jwtTokenUtil;

	@Autowired
	private  MyUserDetailsService userDetailsService;
	
	@Autowired
	private  CompteService compteService;

    
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		authenticationRequest.setRole("client");
		 System.out.println("token: " + token);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken (username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
    @GetMapping("/user")
	public Compte getAuthenticatedUser() {
        final org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final Compte userDetails = (Compte)authentication.getPrincipal();
        return compteService.findById(userDetails.getIdCompte()).get();
    }
	
}
