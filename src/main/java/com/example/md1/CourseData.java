package com.example.md1;

import java.util.Date;

public class CourseData {

    private Integer id;
    private String course;
    private String department;
    private Date dateInsert;
    private Date dateUpdate;
    private Date dateDelete;
    private String status;

    public CourseData(Integer id, String course, String department,
                      Date dateInsert, Date dateUpdate,
                      Date dateDelete, String status) {
        this.id = id;
        this.course = course;
        this.department = department;
        this.dateInsert = dateInsert;
        this.dateUpdate = dateUpdate;
        this.dateDelete = dateDelete;
        this.status = status;
    }


    public Integer getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public String getDepartment() {
        return department;
    }

    public Date getDateInsert() {

        return dateInsert;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public Date getDateDelete() {
        return dateDelete;
    }

    public String getStatus() {
        return status;
    }


}
