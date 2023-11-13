package com.eureka.core.helper;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;

import java.util.Date;

public class StudentMultifieldHelper {

    private String address;
    private int books;
    private Date admissionDate;

    public StudentMultifieldHelper(Resource resource){
        try{
            if(StringUtils.isNotBlank(resource.getValueMap().get("address",String.class))){
                this.address = resource.getValueMap().get("address",String.class);
            }
            if(resource.getValueMap().get("books",Integer.class)!=null){
                this.books=resource.getValueMap().get("books",Integer.class);
            }
            if(resource.getValueMap().get("admissiondate", Date.class)!=null){
                this.admissionDate=resource.getValueMap().get("admissiondate", Date.class);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getAddress() {
        return address;
    }

    public int getBooks() {
        return books;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }
}
