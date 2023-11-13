package com.eureka.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class FormModel {

    @ValueMapValue
    String user;

    @ValueMapValue
    String userplaceholder;

    @ValueMapValue
    String password;

    @ValueMapValue
    String passwordplaceholder;

    @ValueMapValue
    String submit;

    public String getUser() {
        return user;
    }

    public String getUserplaceholder() {
        return userplaceholder;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordplaceholder() {
        return passwordplaceholder;
    }

    public String getSubmit() {
        return submit;
    }

    @PostConstruct
    public String Check() {
        if (password == null) {
            return passwordplaceholder = "Enter something";
        }
        else {
            return passwordplaceholder;
        }
    }
}
