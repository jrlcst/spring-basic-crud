package com.github.jrlcst.service;

import com.github.jrlcst.dto.request.EmployeeRequest;
import com.github.jrlcst.dto.response.EmployeeResponse;
import com.github.jrlcst.exception.CustomException;
import com.github.jrlcst.model.Employee;
import com.github.jrlcst.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public List<EmployeeResponse> findAll() {
        return repository.findAll().stream().map(EmployeeResponse::createByEntity).toList();
    }

    public EmployeeResponse findById(UUID id) {
        return EmployeeResponse.createByEntity(repository.findById(id).orElseThrow(() -> new CustomException("This employee not exists")));
    }

    public EmployeeResponse create(EmployeeRequest request) {
        return EmployeeResponse.createByEntity(repository.save(Employee.createByRequest(request)));
    }

    public EmployeeResponse update(EmployeeRequest request) {
        findById(request.getId());
        return create(request);
    }

    public void delete(UUID id) {
        repository.deleteById(findById(id).getId());
    }
}
