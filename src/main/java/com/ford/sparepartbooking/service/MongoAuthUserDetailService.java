package com.ford.sparepartbooking.service;

import com.ford.sparepartbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MongoAuthUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        com.ford.sparepartbooking.entity.User user = userRepository.findUserByUsername(userName);

        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }

        return new User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }

}