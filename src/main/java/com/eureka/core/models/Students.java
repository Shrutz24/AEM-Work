package com.eureka.core.models;

import com.eureka.core.helper.StudentMultifieldHelper;

import java.util.List;
import java.util.Map;

public interface Students {

    List<String> getStudents();

    List<Map<String,String>> getStudentDetails();



    List<StudentMultifieldHelper> getStudentAdmissionDetails();
}
