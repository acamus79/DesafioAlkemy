package com.acamus.disney.services;

import com.acamus.disney.dto.UserDTO;
import com.acamus.disney.entities.UserEntity;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
public interface UserService {
    
    UserEntity saveUser(UserDTO userDTO);    
}
