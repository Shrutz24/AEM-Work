package com.eureka.core.models;

import com.eureka.core.services.MultiService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultiServiceDemo {
    @OSGiService(filter = "(component.name=com.eureka.core.services.impl.MultiServiceAImpl)" )
    MultiService multiService;

    private String serviceName;

    @PostConstruct
    protected void init(){
        serviceName = multiService.getName();
    }

    public String getServiceName() {
        return serviceName;
    }
}
