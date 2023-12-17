package com.example.md1;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherMain extends AdminMainController implements Initializable {

        @Override
        public void initialize(URL location, ResourceBundle resources) {
                // intializacija tevu klase
                super.initialize(location, resources);


                addSubjectDisplayData();
                addSubjectCourseList();

        }
        @Override
        public void dashboardDisplayTS() {
                // nereikalingas todel tuscias
        }

        @Override
        public void dashboardDisplayTT() {
                // nereikalingas todel tuscias
        }
}






