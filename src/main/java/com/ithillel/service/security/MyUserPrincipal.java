//package com.ithillel.service.security;
//
//import com.ithillel.enums.UserRole;
//import com.ithillel.model.Client;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class MyUserPrincipal implements UserDetails {
//    private Client client;
//    private final ArrayList<GrantedAuthority> grantedAuthorityArraysList = new ArrayList<>();
//
//    public MyUserPrincipal(Client client) {
//        this.client = client;
//        System.out.println("HERE~~~~~~~" + client.getPassword());
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        authorities.add(new SimpleGrantedAuthority(client.getRole().name()));
////        for (UserRole role : client.getRole()) {
////            authorities.add(new SimpleGrantedAuthority(role.getName()));
////        }
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return client.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return client.getLogin();
//    }
//
//    // NOT SURE//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}