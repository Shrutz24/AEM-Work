package com.eureka.core.models.impl;


import com.day.cq.search.QueryBuilder;
import com.day.cq.wcm.api.Page;
import com.eureka.core.models.Author;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables = SlingHttpServletRequest.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
    adapters = Author.class
)
public class AuthorImpl implements Author {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorImpl.class);

    @SlingObject
    ResourceResolver resourceResolver;

    @Self
    SlingHttpServletRequest slingHttpServletRequest;

    @OSGiService
    QueryBuilder queryBuilder;

    @RequestAttribute(name = "rAttribute")
    private String reqAttribute;

    @ResourcePath(path="/content/aemapp")
    @Via("resource")
    Resource resource;

    @ScriptVariable
    Page currentPage;

    @Inject
    @Via("resource")
    @Named("jcr:lastModifiedBy")
    String modifiedBy;



    @Inject
    @Via("resource")
    String fname;

    @ValueMapValue
    String lname;

    @Inject
    @Via("resource")
    boolean professor;

    @Override
    public String getFirstName() {
        return fname;
    }

    @Override
    public String getLastName() {
        return lname;
    }

    @Override
    public boolean getIsProfessor() {
        return professor;
    }

    @Override
    public String getPageTitle(){
        return currentPage.getTitle();
    }

    @Override
    public String getRequestAttribute() {
        return reqAttribute;
    }

    @Override
    public String getHomePageName() {
        return resource.getName();
    }

    @Override
    public String getLastModifiedBy() {
        return modifiedBy;
    }

    @PostConstruct
    protected void init(){
       LOG.info("\n Inside INIT {} ; {}", currentPage.getTitle(), resource.getPath());
    }


}
