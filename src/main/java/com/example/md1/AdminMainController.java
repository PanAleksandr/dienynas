package com.example.md1;

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
import java.util.Date;
import java.util.ResourceBundle;

public class AdminMainController implements Initializable {

    @FXML
    private Button addCourse_btn;

    @FXML
    private Button addStudent_addBtn;

    @FXML
    private Button addStudent_btn;

    @FXML
    private TableColumn<StudentData,String> addStudent_course;

    @FXML
    private TableColumn<StudentData,String> addStudent_dateInsert;

    @FXML
    private Button addStudent_deleteBtn;

    @FXML
    private AnchorPane addStudent_form;

    @FXML
    private TableColumn<StudentData,String> addStudent_name;

    @FXML
    private TableColumn<StudentData,String> addStudent_section;

    @FXML
    private TableColumn<StudentData,String> addStudent_status;

    @FXML
    private TableColumn<StudentData,String> addStudent_studentNumber;

    @FXML
    private TableView<StudentData> addStudent_tableView;

    @FXML
    private Button addStudent_updateBtn;

    @FXML
    private TableColumn<StudentData,String> addStudent_year;

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



    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    private AlertMessage alert = new AlertMessage();

    public ObservableList<StudentData> addStudentGetData(){

        ObservableList<StudentData> listData= FXCollections.observableArrayList();
        String selectData = "SELECT * FROM student WHERE date_delete IS NULL ";

        connect = Database.connectDB();

        StudentData sData;

        try{
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();

            while (result.next()){

                sData = new StudentData(result.getInt("id"), result.getString("student_id")
                        ,result.getString("full_name"),result.getString("year")
                        ,result.getString("course"), result.getString("section")
                        ,result.getString("semester")
                        ,result.getDate("date_insert"),result.getString("status"));
                listData.add(sData);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listData;
    }
    private ObservableList<StudentData> addStudentListData;
    public void addStudentDisplayData(){
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
            ListData.temp_studentNumber = sData.getStudentID();
            ListData.temp_studentName = sData.getFullName();
            ListData.temp_studentBirthDate =sData.getBirthDate();
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

        try{
            Parent root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));

            Stage stage= new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Add Student");
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setAddStudentDeleteBtn(){

        StudentData sData = addStudent_tableView.getSelectionModel().getSelectedItem();
        int num = addStudent_tableView.getSelectionModel().getFocusedIndex();

        Date date= new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

         if ((num-1)<-1){
             alert.errorMessage("Please select item first");
             return;
         }else{
             if (alert.confirmMessage("Are you sure u want to Delete Student ID: "
                     +sData.getStudentID() + "?")){
                 String deleteData = "UPDATE student SET date_delete = ? WHERE student_id = ?";
                 connect=Database.connectDB();

                 try {
                     prepare = connect.prepareStatement(deleteData);
                     prepare.setString(1,String.valueOf(sqlDate));
                     prepare.setString(2,sData.getStudentID());
                     prepare.executeUpdate();
                     alert.successMessage("Deleted successfully!");
                 }catch (Exception e){
                     e.printStackTrace();
                 }
             }else{
                 alert.errorMessage("Cancelled");
             }
         }
         addStudentDisplayData();
    }

    public ObservableList<TeacherData> addTeacherGetData(){

        ObservableList<TeacherData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM teacher WHERE date_delete IS NULL";

        connect= Database.connectDB();
        try{
            prepare=connect.prepareStatement(sql);
            result=prepare.executeQuery();

            TeacherData tData;
            while(result.next()){
            //    TeacherData(Integer id,String teacherID,String fullName,String gender, Date birthDate,
            //            String yearExperience,String experience, String department,
            //            Date dateInsert,Date dateUpdate, Date dateDelete,String status)
                    tData = new TeacherData(result.getInt("id"), result.getString("teacher_id")
                            , result.getString("full_name"),result.getString("gender")
                            , result.getDate("birth_date"),result.getString("year_experience")
                            ,result.getString("experience"),result.getString("department")
                            ,result.getDate("date_insert"),result.getDate("date_update")
                            ,result.getDate("date_delete"),result.getString("status"));
                    listData.add(tData);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listData;
    }

    private  ObservableList<TeacherData> addTeacherListData;
    public void addTeacherDisplayData(){
        addTeacherListData =addTeacherGetData();

        addTeacher_col_teacherID.setCellValueFactory(new PropertyValueFactory<>("teacherID"));
        addTeacher_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        addTeacher_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addTeacher_col_yearExperience.setCellValueFactory(new PropertyValueFactory<>("yearExperience"));
        addTeacher_col_Experience.setCellValueFactory(new PropertyValueFactory<>("experience"));
        addTeacher_col_department.setCellValueFactory(new PropertyValueFactory<>("department"));
        addTeacher_col_dateInsert.setCellValueFactory(new PropertyValueFactory<>("dateInsert"));
        addTeacher_col_Status.setCellValueFactory(new PropertyValueFactory<>("status"));

        addTeacher_tableView.setItems(addTeacherListData);
    }

    public void addTeacherSelectItems(){
        TeacherData tData = addTeacher_tableView.getSelectionModel().getSelectedItem();
        int num = addStudent_tableView.getSelectionModel().getFocusedIndex();

        if ((num-1)<-1) return;
        addTeacher_teacherID.setText(tData.getTeacherID());
        addTeacher_fullName.setText(tData.getFullName());
        addTeacher_gender.getSelectionModel().select(tData.getGender());
        addTeacher_experienceYear.getSelectionModel().select(tData.getYearExperience());
        addTeacher_experience.setText(tData.getExperience());
        addTeacher_department.getSelectionModel().select(tData.getDepartment());
        addTeacher_status.getSelectionModel().select(tData.getStatus());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        addStudentDisplayData();
        addTeacherDisplayData();
    }
}
