package com.example.demo.service;

import com.example.demo.model.UserWhereabouts;
import com.example.demo.model.UserWhereaboutsDto;
import org.springframework.stereotype.Service;

/**
 * Service for processing user details
 */
@Service
public class UserWhereaboutsService {
    /**
     *
     * @param userId user identifier
     * @return user's whereabouts DTO
     */
    public UserWhereaboutsDto getUserWhereabouts(long userId){
        return null;
    }


    /**
     * @param userId User Identifier
     * @return true if success, false if fault
     */
    public boolean deleteUserWhereabouts(long userId){
        return true;
    }

    /**
     *
     * @param userWhereaboutsDto данные нового пользователя
     * @return идентификатор созданной сущности БД
     * <br>Dummy at the moment
     */
    public long createUserWhereabouts(UserWhereaboutsDto userWhereaboutsDto){
        return 0;
    }

    /**
     *
     * @param userId User database Id
     * @param userWhereaboutsDto новые данные пользователя
     * @return true if successfully updated, false if failed
     * <br>Dummy at the moment
     */
    public boolean updateUserWhereabouts(long userId, UserWhereaboutsDto userWhereaboutsDto){
        return true;
    }
}
