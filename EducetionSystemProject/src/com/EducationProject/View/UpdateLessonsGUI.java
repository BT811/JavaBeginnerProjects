package com.EducationProject.View;

import com.EducationProject.Helper.Config;
import com.EducationProject.Helper.Helper;
import com.EducationProject.Model.Lessons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateLessonsGUI extends JFrame {
    private  JPanel wrapper;
    private JTextField fld_lesson_name;
    private JButton btn_update_name;
    private Lessons lesson;
    public  UpdateLessonsGUI(Lessons lesson){
        this.lesson = lesson;
        add(wrapper);
        setSize(300,150);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);


        btn_update_name.addActionListener(e ->{
            if(Helper.isFieldEmpty(fld_lesson_name)){
                Helper.showMsg("fill");
            }else{
                if(Lessons.update(lesson.getId(),fld_lesson_name.getText())){
                    Helper.showMsg("done");
                }
                dispose();
            }

        });
    }


}
