package com.eureka.core.pojos;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class WorkerDetails {
    @ValueMapValue
    String empname;

    @ValueMapValue
    String department;

    @ValueMapValue
    String experience;

    public String getEmpname() {
        return empname;
    }

    public String getDepartment() {
        return department;
    }

    public String getExperience() {
        return experience;
    }
}
