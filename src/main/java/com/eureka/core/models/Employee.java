package com.eureka.core.models;

import com.eureka.core.helper.EmployeeDetails;

import java.util.List;
import java.util.Map;

public interface Employee {

    List<String> getEmployeeId();
    List<Map<String,String>> getPaymentDetails();
    List<EmployeeDetails> getEmployeeDetails();

}
