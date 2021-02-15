package com.myService.Service.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyJson{
    public MyJson(String name) {
        this.name = name;
    }

    public MyJson() {
    }

    @JsonProperty("name")
    public String name=null;


}