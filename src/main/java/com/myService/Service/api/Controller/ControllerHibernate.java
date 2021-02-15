
package com.myService.Service.api.Controller;

import com.myService.Service.Entity.Employees;
import com.myService.Service.Service.EmployeesServiceHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerHibernate {
    private EmployeesServiceHibernate employeesServiceHibernate;

    @Autowired
    public ControllerHibernate(EmployeesServiceHibernate employeesServiceHibernate) {
        this.employeesServiceHibernate = employeesServiceHibernate;
    }

    @RequestMapping(value = "api1/getall")
    public ResponseEntity<List<Employees>> findAll(){

        return employeesServiceHibernate.select();
    }

    @RequestMapping(value="api1/setempl")
    public ResponseEntity<Employees> setEmppl(@RequestBody Employees employees){
        return employeesServiceHibernate.insert(employees);
    }

}
