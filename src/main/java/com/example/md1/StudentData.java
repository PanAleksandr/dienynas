package com.example.md1;
 import java.util.Date;
public class StudentData {


    private Integer id;
    private String studentID;
    private String fullName;
    private String gender;
    private Date birthDate;
    private String year;
    private String course;
    private String section;
    private Date dateInsert;
    private Date dateUpdate;
    private Date dateDelete;
    private String status;
    private String semester;
    private Double firstSem;
    private Double secondSem;
    private Double finals;
    private String subject;

    public StudentData (Integer id, String studentID, String fullName, String gender,
                        Date birthDate,String year, String course, String section,
                        Date dateInsert,Date dateUpdate, Date dateDelete, String status /*,String subject*/){
        this.id= id;
        this.studentID = studentID;
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate= birthDate;
        this.year = year;
        this.course = course;
        this.section= section;

        this.dateInsert= dateInsert;
        this.dateUpdate = dateUpdate;
        this.dateDelete = dateDelete;
        this.status= status;


    }
    public StudentData(Integer id,String studentID,String course ,
                       double firstSem, double secondSem, double finals,String subject){
        this.id=id;
        this.studentID=studentID;
        this.course=course;
        this.firstSem= firstSem;
        this.secondSem=secondSem;
        this.finals=finals;
        this.subject=subject;

    }

    public StudentData(Integer id, String studentID, String fullName, String year, String course,String semester,
                       String section, Date dateInsert, String status){
        this.id= id;
        this.studentID= studentID;
        this.fullName =fullName;
        this.year =year;
        this.course= course;
        this.semester=semester;
        this.section= section;
        this.dateInsert=dateInsert;
        this.status=status;

    }

    public StudentData(int id, String student_id, String course, String first_sem, String second_sem, java.sql.Date aFinal) {
    }

    public StudentData() {

    }

    public Integer getId(){
        return id ;
    }

     public String getStudentID(){
        return studentID;
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
     public String getYear(){
        return  year;
     }
     public String getCourse(){
        return course;
     }
     public String getSemester(){
        return semester;
     }

     public String getSection(){
        return section;
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

public Double getFirstSem(){
        return firstSem;
}
public Double getSecondSem(){
        return secondSem;
}
public Double getFinals(){
        return finals;
}
public String getSubject(){
    return subject;
}
}
