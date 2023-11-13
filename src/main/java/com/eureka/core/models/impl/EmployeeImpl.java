package com.eureka.core.models.impl;

import com.eureka.core.helper.EmployeeDetails;
import com.eureka.core.models.Employee;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.*;

@Model(
        adaptables = Resource.class,
        adapters = Employee.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class EmployeeImpl implements Employee {

    @Inject
    Resource resource;

    @ValueMapValue
    List<String> employeeid;


    @Override
    public List<String> getEmployeeId() {
        if (employeeid != null){
            return new ArrayList<String>(employeeid);
        }else{
            return Collections.emptyList();
        }
    }

    @Override
    public List<Map<String, String>> getPaymentDetails() {
        List<Map<String,String>> payables = new ArrayList<>();
        try{
            Resource money = resource.getChild("paymentdetails");
            if (money != null){
                for (Resource cash:money.getChildren()) {
                    Map<String, String> credits = new HashMap<>();
                    credits.put("salary", cash.getValueMap().get("salary",String.class));
                    credits.put("pf", cash.getValueMap().get("pf",String.class));
                    payables.add(credits);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return payables;
    }

    @Override
    public List<EmployeeDetails> getEmployeeDetails() {
        List<EmployeeDetails> staffDetails = new ArrayList<>();
        try{
            Resource empBean = resource.getChild("employeedetails");
            if(empBean != null){
                for (Resource beanDetails:empBean.getChildren()) {
                    staffDetails.add(new EmployeeDetails(empBean));

                }
            }
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        return staffDetails;
    }
}
