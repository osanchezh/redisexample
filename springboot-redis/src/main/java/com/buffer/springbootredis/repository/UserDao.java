package com.buffer.springbootredis.repository;

import java.util.List;

import com.buffer.springbootredis.model.Usuario;

public interface UserDao {
    boolean saveUser(Usuario user);

    List<Usuario> fetchAllUser();

    Usuario fetchUserById(Long id);

    boolean deleteUser(Long id);

    boolean updateUser(Long id, Usuario user);
}