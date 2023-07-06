package com.EducationProject;

import com.EducationProject.Helper.Config;
import com.EducationProject.Helper.Helper;

import javax.swing.*;

public class StudentGUI extends JFrame{
    private JPanel wrapper;
    public StudentGUI(){
        add(wrapper);
        setSize(800,600);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("Y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
    }
}
