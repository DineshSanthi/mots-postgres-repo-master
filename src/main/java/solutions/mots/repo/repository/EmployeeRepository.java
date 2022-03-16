package solutions.mots.repo.repository;

import org.springframework.stereotype.Repository;

import solutions.mots.repo.base.MotsCrudRepository;
import solutions.mots.repo.entity.Employee;


@Repository
public interface EmployeeRepository extends MotsCrudRepository<Employee, Integer>{

}
