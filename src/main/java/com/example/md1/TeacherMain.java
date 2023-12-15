package com.example.md1;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;





public class TeacherMain extends AdminMainController implements Initializable {

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
}






