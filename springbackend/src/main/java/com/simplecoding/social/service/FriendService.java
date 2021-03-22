package com.simplecoding.social.service;

import com.simplecoding.social.auth.models.UserDto;
import com.simplecoding.social.model.Friend;
import com.simplecoding.social.model.User;
import com.simplecoding.social.repo.FriendRepository;
import com.simplecoding.social.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FriendService {

    @Autowired
    FriendRepository friendRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    public void saveFriend(UserDto userDto1, int id) throws NullPointerException{

        User user = userRepository.getOne(id);
        UserDto userDto2 = modelMapper.map(user,UserDto.class);

        Friend friend = new Friend();
        friend.setCreatedDate(new Date());
        User user1 = userRepository.findUserByEmail(userDto1.getEmail());
        User user2 = userRepository.findUserByEmail(userDto2.getEmail());

        Friend friendViceVersa = new Friend();
        friendViceVersa.setCreatedDate(new Date());
        User firstUser = userRepository.findUserByEmail(userDto2.getEmail());
        User secondUser = userRepository.findUserByEmail(userDto1.getEmail());

        if( !(friendRepository.existsByFirstUserAndSecondUser(user1,user2)) ){
            friend.setFirstUser(user1);
            friend.setSecondUser(user2);

            friendViceVersa.setFirstUser(firstUser);
            friendViceVersa.setSecondUser(secondUser);

            friendRepository.save(friend);
            friendRepository.save(friendViceVersa);
        }

    }

}
