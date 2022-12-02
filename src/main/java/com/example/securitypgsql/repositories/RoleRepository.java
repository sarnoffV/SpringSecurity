package com.example.securitypgsql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securitypgsql.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{}