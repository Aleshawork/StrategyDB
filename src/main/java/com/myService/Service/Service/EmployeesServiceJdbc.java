package com.myService.Service.Service;

import com.myService.Service.Entity.Employees;
import com.myService.Service.Repository.Strategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Component
public class EmployeesServiceJdbc implements Strategy {
    private String SELECT_ALL="select * from emps";
    private String INSERT_EMPL="insert into emps (name,department,salary,hire_date) values (?,?,?,?)";
    private JdbcTemplate jdbcTemplate;
    private Logger logger = LoggerFactory.getLogger(EmployeesServiceJdbc.class);


    @Autowired
    public EmployeesServiceJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public ResponseEntity<List<Employees>> select() {
        List<Employees> list=jdbcTemplate.query(SELECT_ALL,
                (rs, rowNum)->
                        new Employees(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("department"),
                                rs.getInt("salary"),
                                rs.getDate("hire_date")
                        ));
        logger.info("select all employees by Jdbc");

        return  new ResponseEntity<List<Employees>>(list, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employees> insert(Employees employees) {
        jdbcTemplate.update(INSERT_EMPL,employees.getName(),
                employees.getDepartment(),
                employees.getSalary(),
                employees.getDate());
        logger.info("insert new employees by Jdbc");
        return new ResponseEntity<Employees>(employees,HttpStatus.OK);
    }
}
