package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserShortDto;
import com.example.demo.exceptions.ConflictDataException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserDTO create(UserDTO userDTO) {
        if (userRepository.existsByFullNameAndEmail(userDTO.getFullName(), userDTO.getEmail()).isPresent()) {
            throw new ConflictDataException("A user with name: " + userDTO.getFullName() +
                    " and email: " + userDTO.getEmail() + " already exists");
        }
        if (userRepository.existsByEmail(userDTO.getEmail()).isPresent()) {
            throw new ConflictDataException("A user with email " + userDTO.getEmail() + " already exists");
        }
        User user = userMapper.toUser(userDTO);
        User addedUser = userRepository.save(user);
        return userMapper.toUserDto(addedUser);
    }

    public UserDTO update(Long id, String password, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found: " + id));
        if (!user.getPassword().equals(password)) {
            throw new ConflictDataException("Incorrect password");
        }
        if (userDTO.getFullName() != null) user.setFullName(userDTO.getFullName());
        if (userDTO.getPassword() != null) user.setPassword(userDTO.getPassword());
        if (userDTO.getEmail() != null) user.setEmail(userDTO.getEmail());
        if (userDTO.getPhone() != null) user.setPhone(userDTO.getPhone());
        return userMapper.toUserDto(user);
    }

    public void delete(Long id, String password) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found: " + id));
        if (!user.getPassword().equals(password)) {
            throw new ConflictDataException("Incorrect password");
        }
        userRepository.deleteById(id);
    }

    public UserShortDto getUserShortDtoById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found: " + id));
        return userMapper.toUserShortDto(user);
    }

    public UserDTO getFullUserDTOById(Long id, String password) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found: " + id));
        if (!user.getPassword().equals(password)) {
            throw new ConflictDataException("Incorrect password");
        }
        return userMapper.toUserDto(user);
    }

    public List<UserShortDto> getAllShortDto(int from, int size) {
        return userRepository.findAll(PageRequest.of(from / size, size)).stream()
                .map(userMapper::toUserShortDto)
                .collect(Collectors.toList());
    }
}
