package com.buffer.datarediscache.service;

import org.springframework.cache.annotation.Cacheable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.buffer.datarediscache.entity.Usuario;
import com.buffer.datarediscache.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "usuarios", key = "#id")
    public Usuario getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @CachePut(value = "usuarios", key = "#user.id")
    public Usuario saveUser(Usuario user) {
        return userRepository.save(user);
    }

    @CacheEvict(value = "usuarios", key = "#id")
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
