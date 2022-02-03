package com.innova.spring.user.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innova.spring.user.User;
import com.training.spring.aop.Logcu;

@Service
public class UserDataAccess {

    @Autowired
    private IUserDao userDao;

    @Logcu("INFO")
    public void create(final User userParam) {
        this.userDao.save(userParam);
    }

    public User getUserByUsername(final String usernameParam) {
        return this.userDao.findByUsername(usernameParam);
    }

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        Iterable<User> findAllLoc = this.userDao.findAll();
        for (User userLoc : findAllLoc) {
            list.add(userLoc);
        }
        return list;
    }


}
