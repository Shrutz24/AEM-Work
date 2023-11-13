package com.eureka.core.models;
import com.adobe.cq.dam.cfm.ContentFragment;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = Resource.class)
public class ReadCf {

    @ValueMapValue
    private String  cfPath;

    private String empName;

    private String empAddress;


    @Inject
    ResourceResolver resourceResolver;

    @PostConstruct
    protected void init(){
        Resource resource = resourceResolver.getResource(cfPath);
        if (resource  !=  null) {
            ContentFragment contentFragment = resource.adaptTo(ContentFragment.class);
            if (contentFragment != null) {
                empName=contentFragment.getElement("employeName").getContent();
                empAddress=contentFragment.getElement("address").getContent();
            }
        }
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }
}
