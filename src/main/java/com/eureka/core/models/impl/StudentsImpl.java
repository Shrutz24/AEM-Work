package com.eureka.core.models.impl;

import com.eureka.core.helper.StudentMultifieldHelper;
import com.eureka.core.models.Students;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.*;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = Students.class
)
public class StudentsImpl implements Students {

    @Inject
    @Via("resource")
    Resource resource;

    @ValueMapValue
    @Via("resource")
    List<String> students;





    @Override
    public List<String> getStudents() {
        if (students != null){
            return new ArrayList<String>(students);
        }
        else  {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Map<String, String>> getStudentDetails() {

        List<Map<String, String>> studentInfo = new ArrayList<>();

        try{
            Resource info = resource.getChild("studentinfo");
            if (info != null){
                for (Resource information: info.getChildren()) {
                    Map<String,String> candidateMap  = new HashMap<>();
                    candidateMap.put("firstname", information.getValueMap().get("firstname",String.class));
                    candidateMap.put("middlename", information.getValueMap().get("middlename",String.class));
                    candidateMap.put("lastname", information.getValueMap().get("lastname",String.class));

                    studentInfo.add(candidateMap);
                }

            }
        }catch (Exception e){
            System.out.println(e);
        }

        return studentInfo;
    }



    @Override
    public List<StudentMultifieldHelper> getStudentAdmissionDetails() {
        List<StudentMultifieldHelper> admissionInfo = new ArrayList<>();
        try{
            Resource admissionResourceBean = resource.getChild("admissioninfo");
            if(admissionResourceBean != null){
                for (Resource admissionDetails:admissionResourceBean.getChildren()) {
                    admissionInfo.add(new StudentMultifieldHelper(admissionDetails));
                }
            }
        }catch (Exception exc){
            System.out.println(exc.getMessage());
        }

        return admissionInfo;
    }



}
