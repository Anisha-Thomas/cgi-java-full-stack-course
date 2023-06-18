package com.example.employee.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.employee.exception.MyException;
import com.example.employee.model.Department;
import com.example.employee.model.Employee;
import com.example.employee.model.ErrorModel;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService empService;
	private final RestTemplate restTemplate;

	public EmployeeController(EmployeeService empService, RestTemplate restTemplate) {
		super();
		this.empService = empService;
		this.restTemplate = restTemplate;
	}
	@ExceptionHandler(value = NumberFormatException.class)
	public ResponseEntity<ErrorModel> handleException(NumberFormatException e) {
		ErrorModel errorModel = new ErrorModel(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorModel);
	}

	@ExceptionHandler(value = MyException.class)
	public ResponseEntity<ErrorModel> handleIdNotFoundException(MyException e) {
		ErrorModel errorModel = new ErrorModel(HttpStatus.NOT_FOUND.value(), e.getMessage(),
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorModel);

	}
	@PostMapping
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
		Department department=restTemplate.getForObject("http://localhost:8082/department-service/departments/{departmentId}",Department.class, employee.getDepartmentId());
		if(department==null) {
			throw new MyException("Department id not found");
		}
		employee.setDepartmentName(department.getDepartmentName());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(empService.createEmployee(employee));
	}
	@GetMapping("/{id}")
	public Optional<Employee>getEmployeeById(@PathVariable("id") int id){
		return empService.getEmployeeById(id);
	}
}
