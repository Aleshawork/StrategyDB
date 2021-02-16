package com.myService.Service.Service;

import com.myService.Service.Entity.Employees;
import com.myService.Service.Entity.EmployeesEntity;
import com.myService.Service.Repository.EmployeesRepositoryHibernate;
import com.myService.Service.Repository.Strategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Component
public class EmployeesServiceHibernate implements Strategy {

    private EmployeesRepositoryHibernate employeesRepositoryHibernate;
    private Logger logger = LoggerFactory.getLogger(EmployeesServiceHibernate.class);


    @Autowired
    public EmployeesServiceHibernate(EmployeesRepositoryHibernate employeesRepositoryHibernate) {
        this.employeesRepositoryHibernate = employeesRepositoryHibernate;
    }

    @Override
    public ResponseEntity<List<Employees>> select() {

        logger.info("select all employees by Hibernate");
        return new ResponseEntity<List<Employees>>(employeesRepositoryHibernate.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employees> insert(Employees employees) {

        logger.info("insert new employees by Hibernate");
        return new ResponseEntity<Employees>(employeesRepositoryHibernate.save(employees),HttpStatus.OK);
    }
}
