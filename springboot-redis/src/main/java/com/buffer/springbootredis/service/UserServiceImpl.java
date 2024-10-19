package com.buffer.springbootredis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buffer.springbootredis.model.Usuario;
import com.buffer.springbootredis.repository.UserDao;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean saveUser(Usuario user) {
        return userDao.saveUser(user);
    }

    @Override
    public List<Usuario> fetchAllUser() {
        return userDao.fetchAllUser();
    }

    @Override
    public Usuario fetchUserById(Long id) {
        return userDao.fetchUserById(id);
    }

    @Override
    public boolean deleteUser(Long id) {
        return userDao.deleteUser(id);
    }

    @Override
    public boolean updateUser(Long id, Usuario user) {
        return userDao.updateUser(id,user);
    }
}