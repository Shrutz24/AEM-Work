package com.eureka.core.models;

import com.eureka.core.pojos.WorkerDetails;
import com.eureka.core.pojos.WorkerNID;
import com.eureka.core.pojos.WorkerPurchase;
import com.eureka.core.services.IncomeTaxService;
import com.eureka.core.services.TestServices;
import com.eureka.core.services.impl.IncomeTaxServiceImpl;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class WorkerImplentation {



    @Inject
    private List<WorkerNID> employeenid; // Ye hai fied k naam.

    @Inject
    private List<WorkerPurchase> paymentdetails; // Ye hai fied k naam.

    @Inject
    private List<WorkerDetails> employeedetails;

    @OSGiService
    TestServices  testServices;

    @OSGiService
    IncomeTaxService taxService;

    private String printValue;

    private List<Float> taxAmount;

    public String cssValue ="blue";

    public String getPrintValue() {
        return printValue;
    }

    public String calculator ="<b>Hello World</b>";

    public List<WorkerNID> getEmployeenid() {
        return employeenid;
    }

    public List<WorkerPurchase> getPaymentdetails() {
        return paymentdetails;
    }

    public List<WorkerDetails> getEmployeedetails() {
        return employeedetails;
    }
    @PostConstruct
    void init(){
        printValue = testServices.testMethod();
        List <WorkerPurchase> payments = new ArrayList<WorkerPurchase>();
        taxAmount = new ArrayList<Float>();

        Float cost;





        for (WorkerPurchase t:payments ) {
            taxAmount.add(taxService.taxPayment(t.getSalary()));

        }



    }

    public List<Float> getTaxAmount() {
        return taxAmount;
    }
}