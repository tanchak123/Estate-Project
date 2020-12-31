package com.ithillel.service.security;

import com.ithillel.model.Client;
import com.ithillel.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Client client = clientService.getByLogin(s);
        Assert.notNull(client, "client is null");
        System.out.println(client.getRole());
        System.out.println("!@#!#!@#!@#!@");
        User.UserBuilder builder;
            builder = User.withUsername(s);
            builder.password(client.getPassword());
            builder.roles(client.getRole().name());
        return builder.build();
    }
}
