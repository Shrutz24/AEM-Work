//package com.eureka.core.models.impl;
//
//import com.eureka.core.models.Author;
//import org.apache.sling.api.resource.Resource;
//import org.apache.sling.models.annotations.Model;
//import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
//
//@Model(adaptables = Resource.class,
//    adapters = Author.class
//)
//public class AuthorizationImpl implements Author{
//
//    @ValueMapValue
//    String fname;
//
//    @ValueMapValue
//    String lname;
//
//    @ValueMapValue
//    boolean professor;
//
//    String fname_alter;
//    String lname_alter;
//
//
//
//    @Override
//    public String getFirstName() {
//        if(fname != "Suraj"){
//            return fname;
//        }
//        else {
//            fname_alter = "Shine";
//            return fname_alter;
//        }
//    }
//
//    @Override
//    public String getLastName() {
//        if(lname != "Surya"){
//            return lname;
//        }
//        else {
//            lname_alter = "Sun";
//            return lname_alter;
//        }
//    }
//
//    @Override
//    public boolean getIsProfessor() {
//        return professor;
//    }
//}
