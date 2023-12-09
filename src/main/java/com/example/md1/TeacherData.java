package com.example.md1;

import java.util.Date;

public class TeacherData {

    private Integer id;
    private String teacherID;
    private String fullName;
    private String gender;
    private Date birthDate;
    private String yearExperience;
    private String experience;
    private String department;
    private Date dateInsert;
    private Date dateUpdate;
    private Date dateDelete;
    private String status;

    public TeacherData(Integer id,String teacherID,String fullName,String gender, Date birthDate,
                       String yearExperience,String experience, String department,
                       Date dateInsert,Date dateUpdate, Date dateDelete,String status){
                this.id=id;
                this.teacherID=teacherID;
                this.fullName=fullName;
                this.gender=gender;
                this.birthDate=birthDate;
                this.experience=experience;
                this.department=department;
                this.yearExperience =yearExperience;
                this.dateInsert=dateInsert;
                this.dateUpdate=dateUpdate;
                this.dateDelete=dateDelete;
                this.status=status;
    }

    public  String getTeacherID(){
        return teacherID;
    }
    public String getFullName(){
        return fullName;
    }
    public String getGender(){
        return gender;
    }
    public Date getBirthDate(){
        return birthDate;
    }
    public String getYearExperience(){
        return yearExperience;
    }
    public String getExperience(){
        return experience;
    }
    public String getDepartment(){
        return department;
    }
    public Date getDateInsert(){
        return dateInsert;
    }
    public Date getDateUpdate(){
        return dateUpdate;

    }
    public Date getDateDelete(){
        return dateDelete;
    }
    public String getStatus(){
        return status;
    }
    public Integer getId(){
        return id;
    }
}
