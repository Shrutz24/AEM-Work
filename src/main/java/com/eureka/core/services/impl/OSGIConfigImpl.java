package com.eureka.core.services.impl;

import com.eureka.core.services.OSGIConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = OSGIConfig.class, immediate = true)
@Designate(ocd = OSGIConfigImpl.ServiceConfig.class )
public class OSGIConfigImpl  implements OSGIConfig{

    @ObjectClassDefinition(name = "Eureka - OSGI Configuraton",
        description = "Study of OSGI configuration")
    public @interface ServiceConfig{
        @AttributeDefinition(
                name = "Service Name",
                description = "Enter service name.",
                type = AttributeType.STRING)
        public String getServiceName() default "Eureka";

        @AttributeDefinition(
                name = "Service Description",
                description = "Enter service description",
                type = AttributeType.STRING)
        public String getServiceDescription() default "Description";
    }

    private String serviceName;
    private String serviceDescription;

    @Activate
    protected void activate(ServiceConfig serviceConfig){
        serviceName = serviceConfig.getServiceName();
        serviceDescription = serviceConfig.getServiceDescription();
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
