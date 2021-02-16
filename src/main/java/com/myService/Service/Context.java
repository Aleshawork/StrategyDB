package com.myService.Service;

import com.myService.Service.Entity.Employees;
import com.myService.Service.Repository.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class Context {
    private Strategy strategy;





    public void setDataStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public ResponseEntity<List<Employees>> select(){
        return strategy.select();
    }

    public ResponseEntity<Employees> insert(Employees employees){
        return strategy.insert(employees);
    }






}
