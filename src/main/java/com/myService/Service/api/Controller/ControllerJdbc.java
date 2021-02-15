package com.myService.Service.api.Controller;

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
    private EmployeesServiceJdbc employeesService;




         @RequestMapping(value = "/api/getall", method = RequestMethod.GET)
         public ResponseEntity<List<Employees>> getAll(){

        return employeesService.select();
         }

         @RequestMapping(value = "api/setempl",method = RequestMethod.POST)
         public  ResponseEntity<Employees> setEmpl(@RequestBody Employees employees){

            return  employeesService.insert(employees);
         }



}
