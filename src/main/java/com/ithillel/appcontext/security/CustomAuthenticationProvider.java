package com.ithillel.appcontext.security;

import com.ithillel.model.Client;
import com.ithillel.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private ClientService clientService;

    @Override
    public Authentication authenticate(Authentication authentication)
      throws AuthenticationException {
        authentication.getAuthorities().forEach(System.out::println);
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        Client client = clientService.getByLogin(name);
        if (client.getPassword().equals(password)) {
            return new UsernamePasswordAuthenticationToken(
              name, password, new ArrayList<>());
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}