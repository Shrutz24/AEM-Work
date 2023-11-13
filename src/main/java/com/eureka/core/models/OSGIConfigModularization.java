package com.eureka.core.models;

import com.eureka.core.services.OSGIConfigModule;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import javax.annotation.PostConstruct;


@Model(adaptables = SlingHttpServletRequest.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class OSGIConfigModularization {
    @OSGiService
    OSGIConfigModule osgiconfigModule;

    String serviceName;
    String serviceDescription;

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    @PostConstruct
    protected void init(){
        serviceName = osgiconfigModule.getServiceName();
        serviceDescription = osgiconfigModule.getServiceDescription();
    }


}
