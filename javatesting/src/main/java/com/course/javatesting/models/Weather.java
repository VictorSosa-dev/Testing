package com.course.javatesting.models;

import lombok.Data;

@Data
public class Weather {
    private String status;
    private  Integer minTem;

    private Integer maxTem;
}
