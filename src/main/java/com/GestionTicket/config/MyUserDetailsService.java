package com.GestionTicket.config;

import com.GestionTicket.Service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
    private  CompteService personService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return
                (UserDetails) personService.findByEmail (username)
                        .orElseThrow (() -> new UsernameNotFoundException (String.format ("user %s Not Found", username)));
    }
}
