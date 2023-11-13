package com.eureka.core.services.impl;

import com.eureka.core.services.IncomeTaxService;

import org.osgi.service.component.annotations.Component;


@Component(service= IncomeTaxService.class, immediate = true)
public class IncomeTaxServiceImpl implements IncomeTaxService{



    @Override
    public Float taxPayment(Float sal) {
        Float payableTax = 0.0f;

        if (sal <= 500000) return payableTax;
        else if (500000 < sal && sal <=1500000) return payableTax = sal * 0.17f;
        else  return payableTax = sal * 0.4f;


    }
}
