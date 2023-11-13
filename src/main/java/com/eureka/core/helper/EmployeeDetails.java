package com.eureka.core.helper;


import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;


public class EmployeeDetails {
    private String empName;
    private String deptNo;
    private int experience;

    public EmployeeDetails(Resource information){
        try{
            if(StringUtils.isNotBlank(information.getValueMap().get("empname",String.class))){
              this.empName = information.getValueMap().get("empname",String.class);
            }
            if(StringUtils.isNotBlank(information.getValueMap().get("deptno",String.class))){
                this.deptNo = information.getValueMap().get("deptno", String.class);
            }
            if(information.getValueMap().get("experience",Integer.class)!=null){
                this.experience=information.getValueMap().get("experience",Integer.class);
            }
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public String getEmpName() {
        return empName;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public int getExperience() {
        return experience;
    }
}
