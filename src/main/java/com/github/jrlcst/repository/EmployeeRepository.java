package com.github.jrlcst.repository;

import com.github.jrlcst.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    @Override
    Optional<Employee> findById(UUID uuid);
}
