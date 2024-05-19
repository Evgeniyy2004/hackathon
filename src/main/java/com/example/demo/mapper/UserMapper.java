package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserShortDto;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {
    public UserDTO toUserDto(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setFullName(user.getFullName());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        return userDto;
    }

    public User toUser(UserDTO userDTO) {
        User user = new User();
        user.setFullName(userDTO.getFullName());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        return user;
    }

    public UserShortDto toUserShortDto(User user) {
        UserShortDto userShortDto = new UserShortDto();
        userShortDto.setId(user.getId());
        userShortDto.setFullName(user.getFullName());
        return userShortDto;
    }

}
