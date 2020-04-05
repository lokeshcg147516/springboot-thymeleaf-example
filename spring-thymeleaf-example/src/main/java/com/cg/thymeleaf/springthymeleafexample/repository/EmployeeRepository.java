package com.cg.thymeleaf.springthymeleafexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.thymeleaf.springthymeleafexample.dto.EmployeeDTO;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeDTO, Integer> {

}
