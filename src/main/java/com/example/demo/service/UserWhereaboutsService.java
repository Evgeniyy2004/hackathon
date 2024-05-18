package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserWhereabouts;
import org.springframework.stereotype.Service;

/**
 * Service for processing user details
 */
@Service
public class UserWhereaboutsService {
    /**
     *
     * @param userId user indentifier
     * @return user's whereabouts
     */
    public UserWhereabouts getUserWhereabouts(long userId){
        return null;
    }

    public void createUserWhereabouts(){

    }

    public boolean updateUserWhereabouts(UserWhereabouts userWhereabouts){
        return true;
    }
}
