package com.example.md1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class StudentMain extends AdminMainController implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Вызывает инициализацию родительского класса
        super.initialize(location, resources);

        // Дополнительные действия для инициализации TeacherMain
        addSubjectDisplayData();
        addSubjectCourseList();

    }

    @Override
    public void dashboardDisplayTS() {
        // Оставляем этот метод пустым, поскольку он не нужен в TeacherMain
    }

    @Override
    public void dashboardDisplayTT() {
        // Оставляем этот метод пустым, поскольку он не нужен в TeacherMain
    }


    @Override
    public void addSubjectSelectItem() {
    }

    @Override
    public void addSubjectAddBtn() {


    }

    @Override
    public void addSubjectClear() {
    }

    @Override
    public void addSubjectUpdateBtn() {
    }

    @Override
    public void addSubjectDeleteBtn() {

    }


    @Override
    public void addSubjectCourseList() {
    }


    @Override
    public void studentGradesSelect() {


    }
}
