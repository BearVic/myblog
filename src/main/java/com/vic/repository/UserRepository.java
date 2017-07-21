package com.vic.repository;

import com.vic.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by victor on 09/07/2017.
 */

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Integer> {

    @Query(value = "select * from users u where u.username=?1",nativeQuery = true)
    UsersEntity findByUsername(String username);

}
