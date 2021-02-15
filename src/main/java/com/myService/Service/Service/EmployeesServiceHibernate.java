package com.myService.Service.Service;

import com.myService.Service.Entity.Employees;
import com.myService.Service.Entity.EmployeesEntity;
import com.myService.Service.Repository.EmployeesRepositoryHibernate;
import com.myService.Service.Repository.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceHibernate implements Strategy {

    private EmployeesRepositoryHibernate employeesRepositoryHibernate;

    @Autowired
    public EmployeesServiceHibernate(EmployeesRepositoryHibernate employeesRepositoryHibernate) {
        this.employeesRepositoryHibernate = employeesRepositoryHibernate;
    }

    @Override
    public ResponseEntity<List<Employees>> select() {

        return new ResponseEntity<List<Employees>>(employeesRepositoryHibernate.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employees> insert(Employees employees) {

        return new ResponseEntity<Employees>(employeesRepositoryHibernate.save(employees),HttpStatus.OK);
    }
}
