package com.example.md1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AdminMainController implements Initializable {
    @FXML
    private TableColumn<StudentData, String> addSubject_col_studentID;
    @FXML
    private TableColumn<StudentData, String> addSubject_col_final;

    @FXML
    private TableColumn<StudentData, String> addSubject_col_firstSem;

    @FXML
    private TableColumn<StudentData, String> addSubject_col_secondSem;

    @FXML
    private Button addCourse_btn;

    @FXML
    private Button addStudent_addBtn;

    @FXML
    private Button addStudent_btn;

    @FXML
    private TableColumn<StudentData, String> addStudent_course;

    @FXML
    private TableColumn<StudentData, String> addStudent_dateInsert;

    @FXML
    private Button addStudent_deleteBtn;

    @FXML
    private AnchorPane addStudent_form;

    @FXML
    private TableColumn<StudentData, String> addStudent_name;

    @FXML
    private TableColumn<StudentData, String> addStudent_section;

    @FXML
    private TableColumn<StudentData, String> addStudent_status;

    @FXML
    private TableColumn<StudentData, String> addStudent_studentNumber;

    @FXML
    private TableView<StudentData> addStudent_tableView;

    @FXML
    private Button addStudent_updateBtn;

    @FXML
    private TableColumn<StudentData, String> addStudent_year;

    @FXML
    private Button addSubject_btn;

    @FXML
    private Button addTeacher_btn;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Label greet_username;

    ///teacher


    //  @FXML
    //  private Button addSubject_btn;

    @FXML
    private Button addTeacher_addBtn;

    // @FXML
    //  private Button addTeacher_btn;

    @FXML
    private Button addTeacher_clearBtn;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_Experience;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_Status;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_dateInsert;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_department;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_gender;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_name;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_teacherID;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_yearExperience;

    @FXML
    private Button addTeacher_deleteBtn;

    @FXML
    private ComboBox<String> addTeacher_department;

    @FXML
    private TextField addTeacher_experience;

    @FXML
    private ComboBox<String> addTeacher_experienceYear;

    @FXML
    private TextField addTeacher_fullName;

    @FXML
    private ComboBox<String> addTeacher_gender;

    @FXML
    private ComboBox<String> addTeacher_status;

    @FXML
    private TableView<TeacherData> addTeacher_tableView;

    @FXML
    private TextField addTeacher_teacherID;

    @FXML
    private Button addTeacher_updateBtn;

    @FXML
    private AnchorPane addTeacher_form;

    //Course
    @FXML
    private AnchorPane addCourse_form;

    @FXML
    private Button addCourse_addBtn;


    @FXML
    private Button addCourse_clearBtn;

    @FXML
    private TableColumn<CourseData,String> addCourse_col_course;

    @FXML
    private TableColumn<CourseData,String> addCourse_col_dateInsert;

    @FXML
    private TableColumn<CourseData,String> addCourse_col_department;

    @FXML
    private TableColumn<CourseData,String> addCourse_col_status;

    @FXML
    private Button addCourse_deleteBtn;

    @FXML
    private TextField addCourse_department;

    @FXML
    private ComboBox<String> addCourse_status;

    @FXML
    private TableView<CourseData> addCourse_tableView;

    @FXML
    private Button addCourse_updateBtn;

    @FXML
    private TextField addCourse_course;


   // @FXML
   // private ComboBox<?> addSubject_course;

//subject

    @FXML
    private Button addSubject_addBtn;

    @FXML
    private Button addSubject_clearBtn;

    @FXML
    private TextField addSubject_code;

    @FXML
    private TableColumn<SubjectData,String> addSubject_col_code;

    @FXML
    private TableColumn<SubjectData,String> addSubject_col_course;

    @FXML
    private TableColumn<SubjectData,String> addSubject_col_dateInsert;

    @FXML
    private TableColumn<SubjectData,String> addSubject_col_status;

    @FXML
    private TableColumn<SubjectData,String> addSubject_col_subject;

    @FXML
    private ComboBox<String> addSubject_course;

    @FXML
    private Button addSubject_deleteBtn;

    @FXML
    private AnchorPane addSubject_form;

    @FXML
    private ComboBox<String> addSubject_status;

    @FXML
    private TextField addSubject_subject;

    @FXML
    private TableView<StudentData> addSubject_tableView;

    @FXML
    private Button addSubject_updateBtn;


    @FXML
    private TextField studentGrade_firstSem;

    @FXML
    private TextField studentGrade_secondSem;

    @FXML
    private TextField studentGrade_studentNum;
//dashboard
    @FXML
    private AnchorPane dashboard_form;
    @FXML
    private Label dashboard_TS;

    @FXML
    private Label dashboard_TT;


    public void dashboardDisplayTS() {
        String sql = "SELECT COUNT(id) FROM student WHERE date_delete IS NULL";
        connect = Database.connectDB();
        int tempTS = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tempTS = result.getInt("COUNT(id)");
            }
            dashboard_TS.setText("" + tempTS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void dashboardDisplayTT() {
        String sql = "SELECT COUNT(id) FROM teacher WHERE date_delete IS NULL";
        connect = Database.connectDB();
        int tempTT = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tempTT = result.getInt("COUNT(id)");
            }
            dashboard_TT.setText(String.valueOf(tempTT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    private AlertMessage alert = new AlertMessage();

    public ObservableList<StudentData> addStudentGetData() {

        ObservableList<StudentData> listData = FXCollections.observableArrayList();
        String selectData = "SELECT * FROM student WHERE date_delete IS NULL ";

        connect = Database.connectDB();

        StudentData sData;

        try {
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();

            while (result.next()) {

                sData = new StudentData(result.getInt("id"), result.getString("student_id")
                        , result.getString("full_name"), result.getString("year")
                        , result.getString("course"), result.getString("section")
                        , result.getString("semester")
                        , result.getDate("date_insert"), result.getString("status"));
                listData.add(sData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<StudentData> addStudentListData;

    public void addStudentDisplayData() {
        addStudentListData = addStudentGetData();
        addStudent_studentNumber.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        addStudent_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        addStudent_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        addStudent_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        addStudent_dateInsert.setCellValueFactory(new PropertyValueFactory<>("dateInsert"));
        addStudent_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        addStudent_tableView.setItems(addStudentListData);

    }

    public void addStudentUpdateBtn() {

        StudentData sData = addStudent_tableView.getSelectionModel().getSelectedItem();
        int num = addStudent_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            alert.errorMessage("Please select the item first");
            return;
        } else {
            ListData.temp_studentSubject = sData.getSubject();
            ListData.temp_studentNumber = sData.getStudentID();
            ListData.temp_studentName = sData.getFullName();
            ListData.temp_studentBirthDate = sData.getBirthDate();
            ListData.temp_studentYear = sData.getYear();
            ListData.temp_studentCourse = sData.getCourse();
            ListData.temp_studentGender = sData.getGender();
            ListData.temp_studentSemester = sData.getSemester();
            ListData.temp_studentSection = sData.getSection();
            ListData.temp_studentStatus = sData.getStatus();

            try {
                Parent root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
                Stage stage = new Stage();


                stage.setTitle("Update Student");
                stage.setScene(new Scene(root));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void addStudentAddBtn() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Add Student");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAddStudentDeleteBtn() {

        StudentData sData = addStudent_tableView.getSelectionModel().getSelectedItem();
        int num = addStudent_tableView.getSelectionModel().getFocusedIndex();

        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        if ((num - 1) < -1) {
            alert.errorMessage("Please select item first");
            return;
        } else {
            if (alert.confirmMessage("Are you sure u want to Delete Student ID: "
                    + sData.getStudentID() + "?")) {
                String deleteData = "UPDATE student SET date_delete = ? WHERE student_id = ?";
                connect = Database.connectDB();





                try {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.setString(1, String.valueOf(sqlDate));
                    prepare.setString(2, sData.getStudentID());
                    prepare.executeUpdate();
                    alert.successMessage("Deleted successfully!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert.errorMessage("Cancelled");
            }
        }
        addStudentDisplayData();
    }

    public ObservableList<TeacherData> addTeacherGetData() {

        ObservableList<TeacherData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM teacher WHERE date_delete IS NULL";

        connect = Database.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            TeacherData tData;
            while (result.next()) {
               
                tData = new TeacherData(result.getInt("id"), result.getString("teacher_id")
                        , result.getString("full_name"), result.getString("gender")
                        ,  result.getString("year_experience")
                        , result.getString("experience"), result.getString("department")
                        , result.getDate("date_insert"), result.getDate("date_update")
                        , result.getDate("date_delete"), result.getString("status"));
                listData.add(tData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<TeacherData> addTeacherListData;

    public void addTeacherDisplayData() {
        addTeacherListData = addTeacherGetData();

        addTeacher_col_teacherID.setCellValueFactory(new PropertyValueFactory<>("teacherID"));
        addTeacher_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        addTeacher_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addTeacher_col_yearExperience.setCellValueFactory(new PropertyValueFactory<>("yearExperience"));
        addTeacher_col_Experience.setCellValueFactory(new PropertyValueFactory<>("experience"));
        addTeacher_col_department.setCellValueFactory(new PropertyValueFactory<>("department"));
        addTeacher_col_dateInsert.setCellValueFactory(new PropertyValueFactory<>("dateInsert"));
        addTeacher_col_Status.setCellValueFactory(new PropertyValueFactory<>("status"));

        addTeacher_tableView.setItems(addTeacherListData);
    }

    public void addTeacherSelectItems() {
        TeacherData tData = addTeacher_tableView.getSelectionModel().getSelectedItem();
        int num = addStudent_tableView.getSelectionModel().getFocusedIndex();

        if ((num - 1) < -1) return;
        addTeacher_teacherID.setText(tData.getTeacherID());
        addTeacher_fullName.setText(tData.getFullName());
        addTeacher_gender.getSelectionModel().select(tData.getGender());
        addTeacher_experienceYear.getSelectionModel().select(tData.getYearExperience());
        addTeacher_experience.setText(tData.getExperience());
        addTeacher_department.getSelectionModel().select(tData.getDepartment());
        addTeacher_status.getSelectionModel().select(tData.getStatus());
    }

    public void addTeacherGenderList() {

        List<String> listG = new ArrayList<>();

        for (String data : ListData.gender) {
            listG.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listG);
        addTeacher_gender.setItems(listData);
    }

    public void addTeacherEYList() {

        List<String> listEY = new ArrayList<>();

        for (String data : ListData.yearExperience) {
            listEY.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listEY);
        addTeacher_experienceYear.setItems(listData);
    }

    public void addTeacherDepartmentList() {

        List<String> listD = new ArrayList<>();

        for (String data : ListData.department) {
            listD.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listD);
        addTeacher_department.setItems(listData);
    }

    public void addTeacherStatusList() {

        List<String> listS = new ArrayList<>();

        for (String data : ListData.status) {
            listS.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listS);
        addTeacher_status.setItems(listData);
    }

    private String teacherID;
    public void generateTeacherID() {

        String sql = "SELECT MAX(id) FROM teacher";

        connect = Database.connectDB();
        String temp_teacherID = "TID-";
        int temp_count=0;

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()){
                temp_count = result.getInt("MAX(id)");
            }

            if (temp_count==0){
                temp_count +=1;
                teacherID =temp_teacherID + temp_count;
            }else{
                teacherID =temp_teacherID + (temp_count + 1);
            }


        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    public void addTeacherDisplayTeacherID(){
        generateTeacherID();
        addTeacher_teacherID.setText(teacherID);
    }

  public void  addTeacherAddBtn(){

        if(addTeacher_teacherID.getText().isEmpty()
                || addTeacher_fullName.getText().isEmpty()
                || addTeacher_gender.getSelectionModel().getSelectedItem().isEmpty()
                || addTeacher_experience.getText().isEmpty()
                || addTeacher_department.getSelectionModel().getSelectedItem().isEmpty()
                || addTeacher_status.getSelectionModel().getSelectedItem().isEmpty()){
            alert.errorMessage("Please fill all blank fields");
        }else{

            String insertData = "INSERT INTO teacher "
                    + "(teacher_id, full_name,gender, year_experience,"
                    + "experience, department,date_insert,status )"
                    + "VALUES(?,?,?,?,?,?,?,?)";

            connect =Database.connectDB();

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            try{
                prepare = connect.prepareStatement(insertData);
                prepare.setString(1,addTeacher_teacherID.getText());
                prepare.setString(2,addTeacher_fullName.getText());
                prepare.setString(3,addTeacher_gender.getSelectionModel().getSelectedItem());
                prepare.setString(4,addTeacher_experienceYear.getSelectionModel().getSelectedItem());
                prepare.setString(5,addTeacher_experience.getText());
                prepare.setString(6,addTeacher_department.getSelectionModel().getSelectedItem());
                prepare.setString(7,String.valueOf(sqlDate));
                prepare.setString(8,addTeacher_status.getSelectionModel().getSelectedItem());

                prepare.executeUpdate();

                addTeacherDisplayData();//opo


                alert.successMessage("Added Successfully!");

                addTeacherClearBtn();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
  }

  public void addTeacherUpdateBtn() {

      if (addTeacher_teacherID.getText().isEmpty()
              || addTeacher_fullName.getText().isEmpty()
              || addTeacher_gender.getSelectionModel().getSelectedItem().isEmpty()
              || addTeacher_experience.getText().isEmpty()
              || addTeacher_department.getSelectionModel().getSelectedItem().isEmpty()
              || addTeacher_status.getSelectionModel().getSelectedItem().isEmpty()) {
          alert.errorMessage("Please fill all blank fields");
      } else {
          if (alert.confirmMessage("Are u want to Update Teacher ID:" + addTeacher_teacherID.getText() + "?")) {
              Date date = new Date();
              java.sql.Date sqlDate = new java.sql.Date(date.getTime());

              String updateData = "UPDATE teacher SET full_name = '"
                      + addTeacher_fullName.getText() + "', gender = '"
                      + addTeacher_gender.getSelectionModel().getSelectedItem() + "', experience = '"
                      + addTeacher_experience.getText() + "', year_experience = '"
                      + addTeacher_experienceYear.getSelectionModel().getSelectedItem() + "', department = '"
                      + addTeacher_department.getSelectionModel().getSelectedItem() + "', date_update = '"
                      + sqlDate + "', status = '"
                      + addTeacher_status.getSelectionModel().getSelectedItem() + "' "
                      +"WHERE teacher_id = '"
                      + addTeacher_teacherID.getText() + "'";

              connect = Database.connectDB();

              try {
                  prepare = connect.prepareStatement(updateData);
                  prepare.executeUpdate();

                  addTeacherDisplayData();

                  alert.successMessage("Updated Successfully");

              } catch (Exception e) {
                  e.printStackTrace();
              }
          }else{
              alert.errorMessage("Cancelled");

      }
  }
  }
    public void setAddTeacherDeleteBtn(){

        if(addTeacher_teacherID.getText().isEmpty()
            || addTeacher_status.getSelectionModel().getSelectedItem().isEmpty()){
            alert.errorMessage("Please select the item first");
        }else{

            if(alert.confirmMessage("Are you want to Delete Teacher ID:"
                    + addTeacher_teacherID.getText() + "?"))
            {
                String deleteData = "UPDATE teacher SET date_delete = ? WHERE teacher_id = ?";
                connect = Database.connectDB();

                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                try{
                    prepare = connect.prepareStatement(deleteData);
                    prepare.setString(1,""+ sqlDate);
                    prepare.setString(2, addTeacher_teacherID.getText());


                    prepare.executeUpdate();

                    addTeacherDisplayData();

                    alert.successMessage("Deleted Successfully!");

                    addTeacherClearBtn();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                alert.errorMessage("Cancelled");
            }
        }
    }


  public void addTeacherClearBtn(){
        addTeacherDisplayTeacherID();
        addTeacher_fullName.clear();
        addTeacher_gender.getSelectionModel().getSelectedItem();
        addTeacher_experienceYear.getSelectionModel().getSelectedItem();
        addTeacher_experience.clear();
        addTeacher_department.getSelectionModel().getSelectedItem();
        addTeacher_status.getSelectionModel().getSelectedItem();


  }

  public ObservableList<CourseData> addCourseGetData(){

        ObservableList<CourseData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM course WHERE date_delete IS NULL";
        connect= Database.connectDB();

        try{
            prepare =connect.prepareStatement(sql);
            result = prepare.executeQuery();
            CourseData cData;

            while (result.next()){
                cData = new CourseData(result.getInt("id"), result.getString("course"),
                        result.getString("department"), result.getDate("date_insert"),
                        result.getDate("date_update"), result.getDate("date_delete"),
                        result.getString("status"));

                listData.add(cData);
            }



        }catch (Exception e){
            e.printStackTrace();
        }
        return listData;
  }
  private ObservableList<CourseData> addCourseListData;
    public void addCourseDisplayData(){
        addCourseListData = addCourseGetData();

        addCourse_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        addCourse_col_department.setCellValueFactory(new PropertyValueFactory<>("department"));
        addCourse_col_dateInsert.setCellValueFactory(new PropertyValueFactory<>("dateInsert"));
        addCourse_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        addCourse_tableView.setItems(addCourseListData);
    }

    private int courseID = 0;

    public void addCourseSelectItem() {
        CourseData cData = addCourse_tableView.getSelectionModel().getSelectedItem();
        int num = addCourse_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1)
            return;


        addCourse_course.setText(cData.getCourse());
        addCourse_department.setText(cData.getDepartment());
        addCourse_status.getSelectionModel().select(cData.getStatus());

        courseID = cData.getId();
    }

    public void addCourseAddBtn() {

        if (addCourse_course.getText().isEmpty()
                || addCourse_department.getText().isEmpty()
                || addCourse_status.getSelectionModel().getSelectedItem().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            connect = Database.connectDB();

            String checkCourse = "SELECT * FROM course WHERE course = '"
                    + addCourse_course.getText() + "' AND date_delete IS NULL";
            try {
                statement = connect.createStatement();
                result = statement.executeQuery(checkCourse);

                if (result.next()) {
                    alert.errorMessage(addCourse_course.getText() + " is already exist");
                } else {
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    String insertData = "INSERT INTO course (course, department, date_insert, status) "
                            + "VALUES(?,?,?,?)";

                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, addCourse_course.getText());
                    prepare.setString(2, addCourse_department.getText());
                    prepare.setString(3, String.valueOf(sqlDate));
                    prepare.setString(4, addCourse_status.getSelectionModel().getSelectedItem());

                    prepare.executeUpdate();

                    addCourseDisplayData();

                    alert.successMessage("Added Successfully!");

                    addCourseClear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void addCourseUpdateBtn() {

        if (addCourse_course.getText().isEmpty()
                || addCourse_department.getText().isEmpty()
                || addCourse_status.getSelectionModel().getSelectedItem().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            if (alert.confirmMessage("Are you want to Update the course "
                    + addCourse_course.getText() + "?")) {
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                String updateData = "UPDATE course SET course = '"
                        + addCourse_course.getText() + "', department = '"
                        + addCourse_department.getText() + "', date_update = '"
                        + sqlDate + "', status = '"
                        + addCourse_status.getSelectionModel().getSelectedItem() + "' "
                        + "WHERE id = " + courseID;

                connect = Database.connectDB();

                try {
                    prepare = connect.prepareStatement(updateData);
                    prepare.executeUpdate();

                    addCourseDisplayData();

                    alert.successMessage("Updated Successfully!");

                    addCourseClear();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert.errorMessage("Cancelled");
            }
        }
    }

    public void addCourseDeleteBtn() {

        if (courseID == 0) {
            alert.errorMessage("Please select item first");
        } else {

            if (alert.confirmMessage("Are you want to Delete Course "
                    + addCourse_course.getText() + "?")) {
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                String deleteData = "UPDATE course SET date_delete = ? WHERE id = ?";
                connect = Database.connectDB();

                try {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.setString(1, String.valueOf(sqlDate));
                    prepare.setString(2, String.valueOf(courseID));

                    prepare.executeUpdate();

                    addCourseDisplayData();

                    alert.successMessage("Updated Successfully!");

                    addCourseClear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public void addCourseClear() {
        addCourse_course.clear();
        addCourse_department.clear();
        addCourse_status.getSelectionModel().clearSelection();
    }

    public void addCourseStatus() {
        List<String> listS = new ArrayList<>();

        for (String data : ListData.statusA) {
            listS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listS);
        addCourse_status.setItems(listData);
    }

    public ObservableList<SubjectData> addSubjectGetData() {

        ObservableList<SubjectData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM subject WHERE date_delete IS NULL";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            SubjectData sData;

            while (result.next()) {
                sData = new SubjectData(result.getInt("id"),
                        result.getString("subject_code"),
                        result.getString("subject"),
                        result.getString("course"),
                        result.getDate("date_insert"),
                        result.getDate("date_update"),
                        result.getDate("date_delete"),
                        result.getString("status"));

                listData.add(sData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<SubjectData> addSubjectListData;

    private int subjectID = 0;



    public void addSubjectSelectItem() {
        StudentData sData = addSubject_tableView.getSelectionModel().getSelectedItem();
        int num = addSubject_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        //addSubject_code.setText(sData.getSubjectCode());
       addSubject_subject.setText(sData.getSubject());
        studentGrade_studentNum.setText(String.valueOf(sData.getStudentID()));
        studentGrade_firstSem.setText(String.valueOf(sData.getFirstSem()));
        studentGrade_secondSem.setText(String.valueOf(sData.getSecondSem()));
        addSubject_course.getSelectionModel().select(sData.getCourse());
        // addSubject_status.getSelectionModel().select(sData.getStatus());


        subjectID = sData.getId();
    }







    public void addSubjectAddBtn() {


        if (addSubject_code.getText().isEmpty()
                || addSubject_subject.getText().isEmpty()){
            alert.errorMessage("Please 1 fill all blank fields");
        } else {
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                String updateData = "UPDATE subject SET subject_code = '"
                        + addSubject_code.getText() + "', subject = '"
                        + addSubject_subject.getText() + "' "
                        + "WHERE id = " + subjectID;

                connect = Database.connectDB();

                try {
                    prepare = connect.prepareStatement(updateData);
                    prepare.executeUpdate();

                    addSubjectDisplayData();

                    alert.successMessage("Updated Successfully!");

                    addSubjectClear();

                } catch (Exception e) {
                    e.printStackTrace();
                }

        }
        }

    public void addSubjectClear() {
        studentGrade_studentNum.setText("");
     //   studentGrade_year.setText("");
     //   studentGrade_course.setText("");
        studentGrade_firstSem.setText("");
        studentGrade_secondSem.setText("");
      //  addSubject_code.clear();
     //   addSubject_subject.clear();
        addSubject_course.getSelectionModel().clearSelection();
     //   addSubject_status.getSelectionModel().clearSelection();
    }
    public void addSubjectUpdateBtn() {

        double finalCheck1 = 0;
        double finalCheck2 = 0;

        String checkData = "SELECT * FROM subject WHERE student_id = '"
                + studentGrade_studentNum.getText() + "'";

        connect = Database.connectDB();

        double finalResult = 0;

        try {

            prepare = connect.prepareStatement(checkData);
            result = prepare.executeQuery();

            if (result.next()) {
                finalCheck1 = result.getDouble("first_sem");
                finalCheck2 = result.getDouble("second_sem");
            }

            if (finalCheck1 == 0 || finalCheck2 == 0) {
                finalResult = 0;
            } else { // (X+Y)/2
                finalResult = (Double.parseDouble(studentGrade_firstSem.getText())
                        + Double.parseDouble(studentGrade_secondSem.getText()) / 2);
            }

            String updateData = "UPDATE subject SET "
                    + "course = '" + addSubject_course.getSelectionModel().getSelectedItem()
                    + "', first_sem = '" + studentGrade_firstSem.getText()
                    + "', second_sem = '" + studentGrade_secondSem.getText()
                    + "', final = '" + finalResult + "' WHERE student_id = '"
                    + studentGrade_studentNum.getText() + "'";



            if(alert.confirmMessage("Are you sure you want" +
                    " to UPDATE Student #" + studentGrade_studentNum.getText() + "?")){
                statement= connect.createStatement();
                statement.executeUpdate(updateData);


                addSubjectDisplayData();
                } else {
                    return;
                }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/////////////////////////////////////
    public void addSubjectDeleteBtn() {

        if (subjectID == 0) {
            alert.errorMessage("Please select item first");
        } else {

            if (alert.confirmMessage("Are you want to Delete Subject Code: "
                    + addSubject_code.getText() + "?")) {
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                String deleteData = "UPDATE subject SET date_delete = ? WHERE id = ?";
                connect = Database.connectDB();


                try {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.setString(1, String.valueOf(sqlDate));
                    prepare.setString(2, String.valueOf(subjectID));

                    prepare.executeUpdate();

                    addSubjectDisplayData();

                    alert.successMessage("Deleted Successfully!");

                    addSubjectClear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public void addSubjectCourseList() {

        String sql = "SELECT * FROM course WHERE date_delete IS NULL";
        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();

            while (result.next()) {
                listData.add(result.getString("course"));
            }

            addSubject_course.setItems(listData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public ObservableList<StudentData> studentGradesListData() {

        ObservableList<StudentData> listData = FXCollections.observableArrayList();
        String selectData = "SELECT * FROM subject WHERE date_delete IS NULL ";

        connect = Database.connectDB();

        StudentData sData;

        try {
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();

            while (result.next()) {

                sData = new StudentData(result.getInt("id"), result.getString("student_id")
                        , result.getString("course"), result.getDouble("first_sem")
                        , result.getDouble("second_sem")
                        , result.getDouble("final"), result.getString("subject"));
                listData.add(sData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<StudentData> studentGradesList;

    public void addSubjectDisplayData() {
        studentGradesList = studentGradesListData();

        addSubject_col_studentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        addSubject_col_subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        addSubject_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        addSubject_col_firstSem.setCellValueFactory(new PropertyValueFactory<>("firstSem"));
        addSubject_col_secondSem.setCellValueFactory(new PropertyValueFactory<>("secondSem"));
        addSubject_col_final.setCellValueFactory(new PropertyValueFactory<>("finals"));


        addSubject_tableView.setItems(studentGradesList);

    }


        public void studentGradesSelect() {

            StudentData studentD = addSubject_tableView.getSelectionModel().getSelectedItem();
            int num = addSubject_tableView.getSelectionModel().getSelectedIndex();

            if ((num - 1) < -1) {
                return;
            }

            studentGrade_studentNum.setText(String.valueOf(studentD.getStudentID()));
            addStudent_course.setText(studentD.getCourse());
            studentGrade_firstSem.setText(String.valueOf(studentD.getFirstSem()));
            studentGrade_secondSem.setText(String.valueOf(studentD.getSecondSem()));

        }



    public void switchForm(ActionEvent event) {


        if (event.getSource() == dashboard_btn)

        {

            dashboard_form.setVisible(true);
            addStudent_form.setVisible(false);
            addTeacher_form.setVisible(false);
            addCourse_form.setVisible(false);
            addSubject_form.setVisible(false);




        }else if (event.getSource() == addStudent_btn) {
            dashboard_form.setVisible(false);
            addStudent_form.setVisible(true);
            addTeacher_form.setVisible(false);
            addCourse_form.setVisible(false);
            addSubject_form.setVisible(false);


            addStudentDisplayData();
        } else if (event.getSource() == addTeacher_btn) {
            dashboard_form.setVisible(false);
            addStudent_form.setVisible(false);
            addTeacher_form.setVisible(true);
            addCourse_form.setVisible(false);
            addSubject_form.setVisible(false);

            addTeacherDisplayData();
            addTeacherGenderList();

            addTeacherEYList();
            addTeacherDepartmentList();
            addTeacherStatusList();

            addTeacherDisplayTeacherID();
        } else if (event.getSource() == addCourse_btn) {
            dashboard_form.setVisible(false);
            addStudent_form.setVisible(false);
            addTeacher_form.setVisible(false);
            addCourse_form.setVisible(true);
            addSubject_form.setVisible(false);


            addCourseDisplayData();
            addCourseStatus();
        } else if (event.getSource() == addSubject_btn) {
            dashboard_form.setVisible(false);
            addStudent_form.setVisible(false);
            addTeacher_form.setVisible(false);
            addCourse_form.setVisible(false);
            addSubject_form.setVisible(true);


            addSubjectDisplayData();
            addSubjectCourseList();
            //addSubjectStatusList();
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources){
        dashboardDisplayTS();
        dashboardDisplayTT();

    }
}
