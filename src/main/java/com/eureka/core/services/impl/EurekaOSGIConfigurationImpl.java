package com.eureka.core.services.impl;


import com.eureka.core.config.EurekaOSGIConfiguration;
import com.eureka.core.services.OSGIConfigModule;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component( service = OSGIConfigModule.class, immediate = true)
@Designate(ocd = EurekaOSGIConfiguration.class)
public class EurekaOSGIConfigurationImpl implements OSGIConfigModule {

    private String serviceName;
    private String serviceDescription;

    @Activate
    protected void activate(EurekaOSGIConfiguration eurekaOSGIConfiguration) {
        serviceName = eurekaOSGIConfiguration.getServiceName();
        serviceDescription = eurekaOSGIConfiguration.getServiceDescription();
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public String getServiceDescription() {
        return serviceDescription;
    }


}
