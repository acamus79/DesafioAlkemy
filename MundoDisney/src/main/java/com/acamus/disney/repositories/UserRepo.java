package com.acamus.disney.repositories;

import com.acamus.disney.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acamus
 */
@Repository
public interface UserRepo extends JpaRepository<UserEntity, String>{
    UserEntity findByEmail(String email);
}
