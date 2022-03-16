package solutions.mots.repo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import solutions.mots.repo.base.AbstractController;
import solutions.mots.repo.entity.Employee;
import solutions.mots.repo.service.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController extends AbstractController<EmployeeService, Employee>{

	@Autowired
	public EmployeeController(EmployeeService service) {
		super(service);
	}

}
