package com.simplecoding.social.controller;

import com.simplecoding.social.auth.models.UserDto;
import com.simplecoding.social.model.User;
import com.simplecoding.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("private")
public class PrivateEndpoint {

    @Autowired
    UserService userService;

    @GetMapping("/user-details")
    public ResponseEntity<?> getUserInfo(@AuthenticationPrincipal UserDto userDto) {
        User user = userService.getUser(userDto.getEmail());
        return ResponseEntity.ok(user);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<UserDto> saveUserInfo(@AuthenticationPrincipal UserDto userDto) {
        userService.saveUser(userDto);
        return ResponseEntity.ok(userDto);
    }

}
