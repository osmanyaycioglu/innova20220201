package com.innova.spring.user.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.innova.spring.user.ERole;
import com.innova.spring.user.User;

public interface IUserDao extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findByUsernameAndRole(String username,
                               ERole role);

    User findByUsernameAndRoleOrderByUsername(String username,
                                              ERole role);

    @Query("select u from User u where u.username=?1")
    List<User> serchUsername(String username);

    @Query(value = "select * from user u where u.username=?1", nativeQuery = true)
    List<User> serchUsernameNative(String username);

}
