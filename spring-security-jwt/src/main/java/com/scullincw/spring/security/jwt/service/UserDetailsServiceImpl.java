//package com.scullincw.spring.security.jwt.service;
//
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private final UserService userService;
//
//    public UserDetailsServiceImpl(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        User user = userService.findUserByUserName(name);
//        return new JwtUser(user);
//    }
//}