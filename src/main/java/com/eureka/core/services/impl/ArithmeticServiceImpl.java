package com.eureka.core.services.impl;

import com.eureka.core.services.ArithmeticService;
import org.osgi.service.component.annotations.Component;

@Component(service = ArithmeticService.class, immediate = true)
public class ArithmeticServiceImpl implements ArithmeticService{
    Integer num1;
    Integer num2;

    @Override
    public Integer Add(Integer val1, Integer val2) {
        Integer sum = val1 + val2;
        return  sum;
    }

    @Override
    public Integer Sub(Integer val1, Integer val2) {
        Integer sub = val1 - val2;
        return sub;
    }

    @Override
    public Integer Multiply(Integer val1, Integer val2) {
        Integer mul = val1 * val2;
        return mul;
    }

    @Override
    public Integer Divide(Integer val1, Integer val2) {
        try {
            Integer div = val1 / val2;
            return div;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }

    }
}
