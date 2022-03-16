package solutions.mots.repo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import solutions.mots.repo.base.AbstractService;
import solutions.mots.repo.entity.Employee;
import solutions.mots.repo.repository.EmployeeRepository;

@Service
public class EmployeeService extends AbstractService<EmployeeRepository, Employee, Integer>{

	@Autowired
	public EmployeeService(EmployeeRepository repository) {
		super(repository);
	}

}
