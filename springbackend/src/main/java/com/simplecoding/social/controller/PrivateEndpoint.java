package com.simplecoding.social.controller;

import com.simplecoding.social.auth.SecurityService;
import com.simplecoding.social.auth.models.UserDto;
import com.simplecoding.social.model.User;
import com.simplecoding.social.repo.UserRepository;
import com.simplecoding.social.service.FriendService;
import com.simplecoding.social.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("private")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PrivateEndpoint {

    @Autowired
    UserService userService;

    @Autowired
    FriendService friendService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SecurityService securityService;

    @GetMapping("user-details")
    public ResponseEntity<?> getUserInfo(@AuthenticationPrincipal UserDto userDto) {
        User user = userService.getUser(userDto.getEmail());
        return ResponseEntity.ok(user);
    }

    @GetMapping("saveUser")
    public ResponseEntity<UserDto> saveUserInfo(@AuthenticationPrincipal UserDto userDto) {
        userService.saveUser(userDto);
        return ResponseEntity.ok(userDto);
    }

    /*@GetMapping("addFriend")
    public ResponseEntity<?> addUserAsFriend(@AuthenticationPrincipal UserDto userDto){
        User user = userRepository.getOne(2);
        UserDto userDto2 = modelMapper.map(user,UserDto.class);
        friendService.saveFriend(userDto,userDto2);
        return ResponseEntity.ok("ok");
    }*/

    @GetMapping("addFriend")
    public ResponseEntity<?> addUser(@AuthenticationPrincipal @RequestParam("id")String id){
        UserDto currentUser = securityService.getUser();
        User user = userRepository.getOne(Integer.parseInt(id));
        UserDto userDto2 = modelMapper.map(user,UserDto.class);
        friendService.saveFriend(currentUser,userDto2);
        friendService.saveFriend(userDto2,currentUser);
        return ResponseEntity.ok("Friend added successfully");
    }

}
