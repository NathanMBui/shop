package com.example.eshop.service;

import com.example.eshop.data.entity.User;
import com.example.eshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
@RequiredArgsConstructor
public class ShopUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("user detail");
//        User user = userRepository.findByEmailOrMobile(username, username).orElseThrow(() -> new UsernameNotFoundException(String.format("User with name %s not found", username)));
        return withUsername(username)
//                .password(user.getPasswordHash())
//                .authorities(user.isAdmin() ? "admin" : "vendor")
                .password("password")
                .authorities("admin")
//                .accountExpired(false)
//                .accountLocked(false)
//                .credentialsExpired(false)
//                .disabled(false)
                .build();
    }
}
