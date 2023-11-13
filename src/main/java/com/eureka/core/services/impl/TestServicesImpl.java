package com.eureka.core.services.impl;

import com.eureka.core.pojos.WorkerPurchase;
import com.eureka.core.services.TestServices;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.annotation.PostConstruct;
import javax.jcr.Session;


@Component(service = TestServices.class,immediate = true)
public class TestServicesImpl implements TestServices {

    @Reference(target = "(component.name=com.eureka.core.services.impl.MultiServiceAImpl)")
    MultiServiceAImpl multiServicesAImpl;

    String classname;

    public MultiServiceAImpl getMultiServicesAImpl() {
        return multiServicesAImpl;
    }

    @Override
    public String testMethod() {
        return "testMethod working";

    }

    @PostConstruct
    protected void init(){
        classname = multiServicesAImpl.getName();
    }

    public String getClassname() {
        return classname;
    }
}
