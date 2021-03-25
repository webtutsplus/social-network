package com.simplecoding.social.controller;

import com.simplecoding.social.auth.SecurityService;
import com.simplecoding.social.auth.models.UserDto;
import com.simplecoding.social.model.Post;
import com.simplecoding.social.model.User;
import com.simplecoding.social.repo.UserRepository;
import com.simplecoding.social.service.FriendService;
import com.simplecoding.social.service.PostService;
import com.simplecoding.social.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("private")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PrivateEndpoint {

    @Autowired
    UserService userService;

    @Autowired
    FriendService friendService;

    @Autowired
    PostService postService;

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
    public ResponseEntity<?> addUser(@RequestParam("friendId")String friendId) throws NullPointerException{
        UserDto currentUser = securityService.getUser();
        friendService.saveFriend(currentUser,Integer.parseInt(friendId));
        return ResponseEntity.ok("Friend added successfully");
    }

    @GetMapping("listFriends")
    public ResponseEntity<List<User>> getFriends() {
        List<User> myFriends = friendService.getFriends();
        return new ResponseEntity<List<User>>(myFriends, HttpStatus.OK);
    }

    @PostMapping("addPost")
    public ResponseEntity<?> addPost(@RequestBody Post post) throws NullPointerException {
        UserDto user = securityService.getUser();
        Post savedPost = postService.savePost(user,post.getContent());
        return ResponseEntity.created(URI.create("/private/post")).body(savedPost);
    }

    @GetMapping("mypost")
    public ResponseEntity<?> myPosts() throws NullPointerException {
        UserDto user = securityService.getUser();
        List<Post> postList = postService.mypost(user);
        return ResponseEntity.ok(postList);
    }
}
