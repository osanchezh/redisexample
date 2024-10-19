package com.buffer.springbootredis.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.buffer.springbootredis.model.Usuario;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "USER";

    @Override
    public boolean saveUser(Usuario user) {
        try {
            redisTemplate.opsForHash().put(KEY, user.getId().toString(), user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Usuario> fetchAllUser() {
        List<Usuario> users;
        users = redisTemplate.opsForHash().values(KEY);
        return  users;
    }

    @Override
    public Usuario fetchUserById(Long id) {
    	Usuario user;
        user = (Usuario) redisTemplate.opsForHash().get(KEY,id.toString());
        return user;
    }

    @Override
    public boolean deleteUser(Long id) {
        try {
            redisTemplate.opsForHash().delete(KEY,id.toString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(Long id, Usuario user) {
        try {
            redisTemplate.opsForHash().put(KEY, id, user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}