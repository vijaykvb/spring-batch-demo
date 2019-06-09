package com.tetra.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tetra.batch.entity.Users;

/**
 * 
 * @author KVBhaskar
 *
 */
public interface UsersRepository extends JpaRepository<Users, Long> {
}
