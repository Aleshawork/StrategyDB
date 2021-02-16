
package com.myService.Service.api.Controller;

import com.myService.Service.Context;
import com.myService.Service.Entity.Employees;
import com.myService.Service.Service.EmployeesServiceHibernate;
import com.myService.Service.Service.EmployeesServiceJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerHibernate {

    @Autowired
    private Context context;


    @Autowired
    EmployeesServiceHibernate employeesServiceHibernate;



    @RequestMapping(value = "api1/getall")
    public ResponseEntity<List<Employees>> findAllHibernate(){

        context.setDataStrategy(employeesServiceHibernate);
        return context.select();
    }



    @RequestMapping(value="api1/setempl")
    public ResponseEntity<Employees> setEmpplHibername(@RequestBody Employees employees){
        return employeesServiceHibernate.insert(employees);
    }

}
