package com.puj.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.puj.entity.rol;
import com.puj.entity.userEntity;
import com.puj.entity.users.Organizer;
import com.puj.entity.users.Traveler;
import com.puj.repository.rolRepository;
import com.puj.repository.userRepository;

@Service
public class customUserDetailsService implements UserDetailsService {

    @Autowired
    private userRepository userRepository;

    @Autowired
    private rolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userEntity userDB = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));

        UserDetails userDBDetails = new User(username, userDB.getPassword(), getAuthorities(userDB.getRoles()));
        
        return userDBDetails;
    }

    private Collection<GrantedAuthority> getAuthorities(List<rol> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getTipo()))
                .collect(Collectors.toList());
    }

    public userEntity TravelerToUser(Traveler traveler) {
        userEntity user = new userEntity();

        user.setUsername(traveler.getCorreo());
        user.setPassword(passwordEncoder.encode(traveler.getPassword()));
        
        rol rol = rolRepository.findByTipo("VIAJERO").get();
        user.setRoles(List.of(rol));
        return user;
    }

    public userEntity OrganizerToUser(Organizer organizer) {
        userEntity user = new userEntity();

        user.setUsername(organizer.getCorreo());
        user.setPassword(passwordEncoder.encode(organizer.getPassword()));
        
        rol rol = rolRepository.findByTipo("ORGANIZADOR").get();
        user.setRoles(List.of(rol));
        return user;
    }
}