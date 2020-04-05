package com.cg.thymeleaf.springthymeleafexample.sevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.thymeleaf.springthymeleafexample.dto.EmployeeDTO;
import com.cg.thymeleaf.springthymeleafexample.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repository;

	public List<EmployeeDTO> getAllEmployees() {
		List<EmployeeDTO> employees = (List<EmployeeDTO>) repository.findAll();
		if (employees.size() > 0) {
			return employees;
		} else {
			return new ArrayList<EmployeeDTO>();
		}
	}

	public EmployeeDTO getEmployee(int id) {
		Optional<EmployeeDTO> emp = repository.findById(id);
		EmployeeDTO employeeDTO = emp.get();

		if (null != employeeDTO) {
			return employeeDTO;
		}

		return new EmployeeDTO();
	}

	public EmployeeDTO createOrUpdateEmployee(EmployeeDTO employeeDTO) {
		if (employeeDTO.getEmpId() == 0) {
			employeeDTO = repository.save(employeeDTO);

			return employeeDTO;
		} else {
			Optional<EmployeeDTO> employee = repository.findById(employeeDTO.getEmpId());

			if (employee.isPresent()) {
				EmployeeDTO newemployeeDTO = employee.get();
				newemployeeDTO.setEmail(employeeDTO.getEmail());
				newemployeeDTO.setFirstName(employeeDTO.getFirstName());
				newemployeeDTO.setLastName(employeeDTO.getLastName());

				newemployeeDTO = repository.save(newemployeeDTO);

				return newemployeeDTO;
			} else {
				employeeDTO = repository.save(employeeDTO);

				return employeeDTO;
			}
		}
	}
	
	 public void deleteEmployeeById(int id) 
	    {
	        Optional<EmployeeDTO> employee = repository.findById(id);
	         
	        if(employee.isPresent()) 
	        {
	            repository.deleteById(id);
	        } else {
	            throw new RuntimeException("No employee record exist for given id");
	        }
	    } 
}
