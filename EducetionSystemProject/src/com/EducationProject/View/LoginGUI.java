package com.EducationProject.View;

import com.EducationProject.EducatorGUI;
import com.EducationProject.Helper.Config;
import com.EducationProject.Helper.Helper;
import com.EducationProject.Model.Operator;
import com.EducationProject.Model.User;
import com.EducationProject.StudentGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends  JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_user_uname;
    private JPasswordField fld_user_pass;
    private JButton btn_login;

    public LoginGUI(){
        add(wrapper);
        setSize(450,450);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("Y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        btn_login.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_user_pass)||Helper.isFieldEmpty(fld_user_pass)){
                Helper.showMsg("fill");
            }else{
                User u = User.getFetch(fld_user_uname.getText(),fld_user_pass.getText());
                if(u == null){
                    Helper.showMsg("Wrong User name or password.");
                }else{
                    Helper.showMsg("Succsess");
                    switch (u.getTyp()){
                        case "operator":
                            OperatorGUI opGUI = new OperatorGUI((Operator) u);
                            break;
                        case  "educator":
                            EducatorGUI edGUI = new EducatorGUI();
                            break;
                        case "student":
                            StudentGUI stGUI = new StudentGUI();
                            break;
                    }
                    dispose();
                }

            }

        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        LoginGUI login = new LoginGUI();
    }
}
