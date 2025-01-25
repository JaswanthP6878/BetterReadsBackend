package com.juswan.betterreads.service;


import com.juswan.betterreads.domain.User;
import com.juswan.betterreads.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.User.UserBuilder;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

     @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);

         UserBuilder builder = null;
         if (user.isPresent()) {
             User appuser;
             appuser = user.get();
             builder = org.springframework.security.core.userdetails.
                     User.withUsername(username);
             builder.password(appuser.getPassword());
             builder.roles(appuser.getRole());
         } else {
             throw new UsernameNotFoundException("user not found");
         }

         return builder.build();
    }
}
