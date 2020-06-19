package com.example.demo.repository;

import com.example.demo.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<AppRole, Long> {
}
