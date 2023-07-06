package com.EducationProject.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public  static  void setLayout(){
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException |RuntimeException |InstantiationException |IllegalAccessException |UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static int screenCenterPoint(String axis , Dimension size){
        int point ;
        switch (axis){
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point = 0;
        }
        return point;

    }
    public  static  boolean isFieldEmpty(JTextField field){
        return  field.getText().trim().isEmpty();
    }

    public static void showMsg(String str){
        String msg;
        String title;
        switch (str){
            case "fill":
                msg = "Fill in all fields";
                title = "Error";
                break;
            case "error":
                msg = "Error";
                title = "Eror";
            default:
                msg=str;
                title = "Message";
        }
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }
    public static  boolean confrim(String str){
        String msg;
        switch (str){
            case "sure":
                msg= "Are you sure about the transaction ??";
                break;
            default:
                msg = str;
        }

        return JOptionPane.showConfirmDialog(null,msg,"Delete",JOptionPane.YES_NO_OPTION) == 0;
    }
}
