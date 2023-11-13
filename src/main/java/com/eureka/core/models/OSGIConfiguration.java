package com.eureka.core.models;

import com.eureka.core.services.OSGIConfig;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import javax.annotation.PostConstruct;

@Model(adaptables = SlingHttpServletRequest.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class OSGIConfiguration {
    @OSGiService
    OSGIConfig osgiService;

    String osgiServiceName;
    String osgiServiceDescription;

    public String getOsgiServiceName() {
        return osgiServiceName;
    }

    public String getOsgiServiceDescription() {
        return osgiServiceDescription;
    }

    @PostConstruct
    protected void init(){
        osgiServiceName = osgiService.getServiceName();
        osgiServiceDescription = osgiService.getServiceDescription();
    }
}
