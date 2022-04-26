
package com.acamus.disney.services.impl;

import com.acamus.disney.dto.UserDTO;
import com.acamus.disney.entities.UserEntity;
import com.acamus.disney.enums.Rol;
import com.acamus.disney.repositories.UserRepo;
import com.acamus.disney.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity saveUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntity.setRole(Rol.USER);
        userEntity = this.userRepository.save(userEntity);

        return userEntity;
    }
    
}
