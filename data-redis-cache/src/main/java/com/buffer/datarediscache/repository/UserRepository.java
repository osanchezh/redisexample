package com.buffer.datarediscache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buffer.datarediscache.entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario,Long> {
}
