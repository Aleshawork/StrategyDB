package com.myService.Service.Repository;

import com.myService.Service.Entity.Employees;
import com.myService.Service.Entity.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepositoryHibernate extends JpaRepository<Employees,Long> {

}
