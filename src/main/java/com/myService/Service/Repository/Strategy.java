package com.myService.Service.Repository;

import com.myService.Service.Entity.Employees;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface Strategy {
    public ResponseEntity<List<Employees>> select();

    public ResponseEntity<Employees> insert(Employees employees);
}
