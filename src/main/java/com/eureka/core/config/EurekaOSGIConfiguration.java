package com.eureka.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Eureka OSGI Modularization",
    description = "Modularization of OSGI Configurations")
public @interface EurekaOSGIConfiguration {
    @AttributeDefinition(
            name = "Service Name",
            description = "Enter the service name.",
            type = AttributeType.STRING)
    public String getServiceName() default "Modular Service";

    @AttributeDefinition(
            name = "Service Description",
            description = "Provide the service description.",
            type = AttributeType.STRING)
    public String getServiceDescription() default "Modular Service Description";
}
