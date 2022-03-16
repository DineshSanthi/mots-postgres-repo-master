package solutions.mots.repo.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import solutions.mots.repo.enumeration.Gender;


@Entity
@Table(name="Employee")
public class Employee implements Serializable{
	
	@Id
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "emp_no", nullable = false)
	private Long empNo;

	@Column(name = "birth_date", nullable = false)
	private Date birthDate;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "gender", nullable = false)
	private String gender;    
	
	@Column(name = "hire_date", nullable = false)
	private Date hireDate;
	
	
	public Long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}	
	
}


