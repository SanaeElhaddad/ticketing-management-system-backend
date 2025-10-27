package com.GestionTicket.Service;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.GestionTicket.DTO.LoginRequest;
import com.GestionTicket.DTO.UserDetailsDTO;
import com.GestionTicket.Entitie.Agent;
import com.GestionTicket.Entitie.Client;
import com.GestionTicket.Entitie.Compte;
import com.GestionTicket.Repository.AgentRepository;
import com.GestionTicket.Repository.ClientRepository;
import com.GestionTicket.Repository.CompteRepository;

import jakarta.servlet.http.HttpServletRequest;



@Service
public class AuthService {
	
//	@Autowired
//    private CompteRepository compteRepository;
//	
//	@Autowired
//	private ClientRepository clientRepository;
//
//	@Autowired
//	private AgentRepository agentRepository;
//	
//   @Autowired
//   JWTUils jwtUils;
//   
//   @Autowired
//   private AuthenticationManager authenticationManager;
//
//   @Autowired
//   private PasswordEncoder passwordEncoder;
//
//   public LoginRequest register(LoginRequest registrationRequest){
//       LoginRequest Req = new LoginRequest();
//
//       try {
//           Compte compte = new Compte();
//           compte.setEmail(registrationRequest.getEmail());
//           compte.setNomUtilisateur(registrationRequest.getNomUtilisateur());
//           compte.setRole(registrationRequest.getRole());
//           compte.setMotDePasse(passwordEncoder.encode(registrationRequest.getMotDePasse()));
//           if (registrationRequest.getClient() != null && registrationRequest.getClient().getIdClient() != null) {
//        	   Long clientId = registrationRequest.getClient().getIdClient();
//               Client client = clientRepository.findById(clientId)
//                                               .orElseThrow(() -> new RuntimeException("Client not found with id: " + clientId));
//               compte.setClient(client);
//           }
//           else {
//        	   Long agentId=registrationRequest.getAgent().getIdAgent();
//               Agent agent = agentRepository.findById(agentId)
//                       .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));
//               compte.setAgent(agent);	
//           }
//              
//           //compte.setClient(registrationRequest.getCompte().getClient());
//           Compte usersResult = compteRepository.save(compte);
//           if (usersResult.getIdCompte()>0) {
//        	   Req.setCompte(usersResult);
//        	   Req.setMessage("User Saved Successfully");
//        	   Req.setStatusCode(200);
//           }
//
//       }catch (Exception e){
//    	   Req.setStatusCode(500);
//    	   Req.setErreur(e.getMessage());
//       }
//       return Req;
//   }
//   
//   
//   //login:
//   
//   public LoginRequest login(LoginRequest loginRequest){
//	   LoginRequest response = new LoginRequest();
//       try {
////           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getMotDePasse()));
////             Compte user = compteRepository.findByEmail(loginRequest.getEmail());
////             if (user == null) {
////            	 System.out.println("User not found with email: " + loginRequest.getEmail());
////             }
////             var jwt = jwtUils.generateToken(user);
////             var refreshToken = jwtUils.generateRefreshToken(new HashMap<>(), user);
////            response.setStatusCode(200);
////            response.setToken(jwt);
////            response.setRole(user.getRole());
////            response.setRefreshToken(refreshToken);
////            response.setExpirationTime("24Hrs");
////            response.setMessage("Successfully Logged In");
////            response.setCompte(user);
////           if (user.getClient() != null) {
////               response.setClient(user.getClient());
////           } else if (user.getAgent() != null) {
////               response.setAgent(user.getAgent());
////           }
//
//       }catch (Exception e){
//           response.setStatusCode(500);
//           response.setMessage(e.getMessage());
//       }
//       return response;
//   }
//   
//   public Compte findByEmail(String email) {
//       return compteRepository.findByEmail(email);
//   }
//   
//   public LoginRequest refreshToken(LoginRequest refreshTokenReqiest){
//	   LoginRequest response = new LoginRequest();
//       try{
//           String ourEmail = jwtUils.extractUsername(refreshTokenReqiest.getToken());
//           Compte users = compteRepository.findByEmail(ourEmail);
//           if (jwtUils.isTokenValid(refreshTokenReqiest.getToken(), users)) {
//               var jwt = jwtUils.generateToken(users);
//               response.setStatusCode(200);
//               response.setToken(jwt);
//               response.setRefreshToken(refreshTokenReqiest.getToken());
//               response.setExpirationTime("24Hr");
//               response.setMessage("Successfully Refreshed Token");
//           }
//           response.setStatusCode(200);
//           return response;
//
//       }catch (Exception e){
//           response.setStatusCode(500);
//           response.setMessage(e.getMessage());
//           return response;
//       }
//   }
// /*  public LoginRequest getAllUsers() {
//	   LoginRequest reqRes = new LoginRequest();
//
//       try {
//           List<Compte> result = compteRepository.findAll();
//           if (!result.isEmpty()) {
//               reqRes.setComptes(result);
//               reqRes.setStatusCode(200);
//               reqRes.setMessage("Successful");
//           } else {
//               reqRes.setStatusCode(404);
//               reqRes.setMessage("No users found");
//           }
//           return reqRes;
//       } catch (Exception e) {
//           reqRes.setStatusCode(500);
//           reqRes.setMessage("Error occurred: " + e.getMessage());
//           return reqRes;
//       }
//   }*/
//   
//   public Compte getCompteByEmail(String email) {
//       return compteRepository.findByEmail(email); 
//   }
//   
//   
//
}

