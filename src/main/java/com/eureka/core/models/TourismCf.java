package com.eureka.core.models;

import com.adobe.cq.dam.cfm.ContentFragment;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TourismCf {

    @ValueMapValue
    private String tourismResource;

    private String state;
    private String visitorDescription;


    @Inject
    ResourceResolver tourResource;

    @PostConstruct
    protected void init() {
            Resource tripResource = tourResource.getResource(tourismResource);
            if (tripResource != null) {
                ContentFragment contentFragment = tripResource.adaptTo(ContentFragment.class);
                if (contentFragment != null) {
                    state = contentFragment.getElement("state").getContent();
                    visitorDescription = contentFragment.getElement("descriptionOfVisitors").getContent();
                }
            }
    }
    public String getState() {
        return state;
    }

    public String getVisitorDescription() {
        return visitorDescription;
    }
}
