package com.myService.Service.api.Controller;

import com.myService.Service.Context;
import com.myService.Service.Entity.Employees;
import com.myService.Service.Service.EmployeesServiceJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerJdbc {

    @Autowired
    private EmployeesServiceJdbc employeesServiceJdbc;

    @Autowired
    Context context;



         @RequestMapping(value = "api2/getall", method = RequestMethod.GET)
         public ResponseEntity<List<Employees>> getAllJdbc(){
             context.setDataStrategy(employeesServiceJdbc);

        return context.select();
         }

         @RequestMapping(value = "api2/setempl",method = RequestMethod.POST)
         public  ResponseEntity<Employees> setEmplJdbc(@RequestBody Employees employees){

            return  context.insert(employees);
         }



}
