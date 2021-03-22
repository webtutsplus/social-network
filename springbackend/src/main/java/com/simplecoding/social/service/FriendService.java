package com.simplecoding.social.service;

import com.simplecoding.social.auth.models.UserDto;
import com.simplecoding.social.model.Friend;
import com.simplecoding.social.model.User;
import com.simplecoding.social.repo.FriendRepository;
import com.simplecoding.social.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FriendService {

    @Autowired
    FriendRepository friendRepository;

    @Autowired
    UserRepository userRepository;

    public void saveFriend(UserDto userDto1,UserDto userDto2){
        Friend friend = new Friend();
        friend.setCreatedDate(new Date());
        User user1 = userRepository.findUserByEmail(userDto1.getEmail());
        User user2 = userRepository.findUserByEmail(userDto2.getEmail());
        if( !(friendRepository.existsByFirstUser(user1) && friendRepository.existsBySecondUser(user2) )) {
            friend.setFirstUser(user1);
            friend.setSecondUser(user2);
            friendRepository.save(friend);
        }
    }

}
