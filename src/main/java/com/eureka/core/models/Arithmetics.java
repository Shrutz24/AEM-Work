package com.eureka.core.models;


import com.eureka.core.services.ArithmeticService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class)
public class Arithmetics {

    @ValueMapValue
    Integer firstnum;

    @ValueMapValue
    Integer secondnum;

    Integer answer;
    @OSGiService
    ArithmeticService arithmeticService;

    Integer addition;
    Integer subtraction;

    Integer multiplication;

    Integer division;

    public Integer getFirstnum() {
        return firstnum;
    }

    public Integer getSecondnum() {
        return secondnum;
    }

    public Integer getAddition() {
        return addition;
    }

    public Integer getSubtraction() {
        return subtraction;
    }

    public Integer getMultiplication() {
        return multiplication;
    }

    public Integer getDivision() {
        return division;
    }

    @PostConstruct

    protected void init() {
        addition = arithmeticService.Add(firstnum, secondnum);
        subtraction = arithmeticService.Sub(firstnum, secondnum);
        multiplication = arithmeticService.Multiply(firstnum, secondnum);
        division = arithmeticService.Divide(firstnum,secondnum);

    }
}
