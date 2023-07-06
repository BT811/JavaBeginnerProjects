package com.EducationProject.View;

import com.EducationProject.Helper.Config;
import com.EducationProject.Helper.Helper;
import com.EducationProject.Helper.Item;
import com.EducationProject.Model.Course;
import com.EducationProject.Model.Lessons;
import com.EducationProject.Model.Operator;
import com.EducationProject.Model.User;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private final Operator operator;
    private JTabbedPane tab_oparator;
    private JLabel lbl_welcome;
    private JButton btn_exit;
    private JPanel onl_user_list;
    private JScrollPane scrl_user_list;
    private JTable tbl_user_list;
    private JPanel pnl_user_form;
    private JTextField fld_user_name;
    private JTextField fld_user_uname;
    private JTextField fld_user_pass;
    private JComboBox cmb_user_type;
    private JButton btn_user_add;
    private JTextField fld_user_id;
    private JButton btn_user_delete;
    private JTextField fld_sh_user_name;
    private JTextField fld_sh_user_uname;
    private JComboBox cmb_sh_user_type;
    private JButton btn_user_sh;
    private JPanel pnl_lessons_list;
    private JTable tbl_lessons_list;
    private JScrollPane scrl_lessons_list;
    private JPanel pnl_lessons_add;
    private JTextField fld_lesson_name;
    private JButton btn_lesson_add;
    private JPanel pnl_course_list;
    private JScrollPane scrl_course_list;
    private JTable tbl_course_list;
    private JTextField fld_course_name;

    private JTextField fld_course_lang;

    private JComboBox cmb_course_lessons;
    private JComboBox cmb_course_user;
    private JButton btn_course_add;
    private DefaultTableModel mdl_user_list;
    private Object[] row_user_list;
    private  DefaultTableModel mdl_lessons_list;
    private  Object[] row_lessons_list;
    private  JPopupMenu lessonsMenu;
    private  DefaultTableModel mdl_course_list;
    private  Object[] row_course_list;


    public  OperatorGUI(Operator operator){

        this.operator = operator;
        add(wrapper);
        setSize(800,600);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        lbl_welcome.setText("Welcome "+ operator.getName());


        //ModelUserList
        mdl_user_list = new DefaultTableModel(){
            @Override
            public  boolean isCellEditable (int row, int column){
                if(column == 0)return false;
                return super.isCellEditable(row,column);
            }
        };
        Object[] col_user_list ={"ID","Name","User Name","Password","User Type"};
        mdl_user_list.setColumnIdentifiers(col_user_list);
        row_user_list = new Object[col_user_list.length];
        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);
        loadUserModel();

        tbl_user_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                String  select_user_id = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),0).toString();
                fld_user_id.setText(select_user_id);
            }catch (Exception exception){

            }

        });

        tbl_user_list.getModel().addTableModelListener(e-> {
            if(e.getType() == TableModelEvent.UPDATE){
                int user_id = Integer.parseInt(tbl_user_list.getValueAt(tbl_user_list.getSelectedRow() , 0).toString());
                String user_name = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),1).toString();
                String user_uname = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),2).toString();
                String user_pass = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),3).toString();
                String user_type = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),4).toString();
                if(User.update(user_id,user_name,user_uname,user_pass,user_type)){
                    Helper.showMsg("Done");
                }
                loadUserModel();
                loadEducatorCombo();
                loadCourseModel();
            }
        });
   //Lessons List
        lessonsMenu = new JPopupMenu();
        JMenuItem updateMenu = new JMenuItem("Update");
        JMenuItem deleteMenu = new JMenuItem("Delete");
        lessonsMenu.add(updateMenu);
        lessonsMenu.add(deleteMenu);

        updateMenu.addActionListener(e->{
            int selec_id = Integer.parseInt(tbl_lessons_list.getValueAt(tbl_lessons_list.getSelectedRow(),0).toString());
            UpdateLessonsGUI updateGUI = new UpdateLessonsGUI(Lessons.getFetch(selec_id));
            updateGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadLessonsMdl();
                    loadLessonsCombo();
                    loadCourseModel();
                }
            });
        });

        deleteMenu.addActionListener(e -> {
            if(Helper.confrim("sure")){
                int select_id = Integer.parseInt(tbl_lessons_list.getValueAt(tbl_lessons_list.getSelectedRow(),0).toString());
                if(Lessons.delete(select_id)){
                    Helper.showMsg("done");
                    loadLessonsMdl();
                    loadLessonsCombo();
                    loadCourseModel();
                }else {
                    Helper.showMsg("error");
                }
            }
        });

        //Course List

        mdl_course_list = new DefaultTableModel();
        Object[] col_courseList = {"iD","Course Name","Software Language","Lesson","Educator"};
        mdl_course_list.setColumnIdentifiers(col_courseList);
        row_course_list = new Object[col_courseList.length];

        loadCourseModel();

        tbl_course_list.setModel(mdl_course_list);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);

        loadLessonsCombo();
        loadEducatorCombo();


        //Course List End


        mdl_lessons_list = new DefaultTableModel();
        Object[] col_lessons_list = {"ID","Lesson's Name"};
        mdl_lessons_list.setColumnIdentifiers(col_lessons_list);
        row_lessons_list = new Object[col_lessons_list.length];
        loadLessonsMdl();

        tbl_lessons_list.setModel(mdl_lessons_list);
        tbl_lessons_list.setComponentPopupMenu(lessonsMenu);
        tbl_lessons_list.getTableHeader().setReorderingAllowed(false);
        tbl_lessons_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_lessons_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
               Point point = e.getPoint();
               int selected_row = tbl_lessons_list.rowAtPoint(point);
               tbl_lessons_list.setRowSelectionInterval(selected_row,selected_row);
            }
        });




        btn_user_add.addActionListener(e-> {
            if( Helper.isFieldEmpty(fld_user_name) || Helper.isFieldEmpty(fld_user_pass) || Helper.isFieldEmpty(fld_user_uname)){
               Helper.showMsg("fill");
            }else{
                String name = fld_user_name.getText();
                String pass = fld_user_pass.getText();
                String uname = fld_user_uname.getText();
                String typ = cmb_user_type.getSelectedItem().toString();
                if(User.add(name,uname,pass,typ)){
                    Helper.showMsg("Done");
                    loadUserModel();
                    loadEducatorCombo();
                    fld_user_pass.setText(null);
                    fld_user_name.setText(null);
                    fld_user_uname.setText(null);
                }
            }


        });
        btn_user_delete.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_user_id)){
                Helper.showMsg("fill");
            }else{
               if(Helper.confrim("sure")){
                   int user_id = Integer.parseInt(fld_user_id.getText());
                   if(User.delete(user_id)){
                       Helper.showMsg("done");
                       fld_user_id.setText(null);
                       loadUserModel();
                       loadEducatorCombo();
                       loadCourseModel();

                   }else
                       Helper.showMsg("error");
               }
            }
        });
        btn_user_sh.addActionListener(e -> {
            String name = fld_sh_user_name.getText();
            String uname = fld_sh_user_uname.getText();
            String type = cmb_sh_user_type.getSelectedItem().toString();
            String query = User.searchQuery(name,uname,type);

            loadUserModel(User.searchUserList(query));
        });
        btn_exit.addActionListener(e -> {
            dispose();
            LoginGUI l = new LoginGUI();
        });
        btn_lesson_add.addActionListener(e->{
            if(Helper.isFieldEmpty(fld_lesson_name)){
                Helper.showMsg("fill");
            }else{
                if(Lessons.add(fld_lesson_name.getText())){
                    Helper.showMsg("done");
                    loadLessonsMdl();
                    loadLessonsCombo();
                    fld_lesson_name.setText(null);
                }else{
                    Helper.showMsg("error");
                }
            }
        });




        btn_course_add.addActionListener(e -> {
            Item lessonsItem = (Item) cmb_course_lessons.getSelectedItem();
            Item userItem = (Item) cmb_course_user.getSelectedItem();
            if(Helper.isFieldEmpty(fld_course_name) || Helper.isFieldEmpty(fld_course_lang)){
                Helper.showMsg("fill");
            }else{
                if(Course.add(userItem.getKey(),lessonsItem.getKey(),fld_course_name.getText(),fld_course_lang.getText()))
                    Helper.showMsg("done");
                loadCourseModel();
                fld_course_lang.setText(null);
                fld_course_name.setText(null);
            }

        });

    }

    private void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        int i=0;
        for(Course obj : Course.getList()){
            i= 0;
            row_course_list[i++] = obj.getId();
            row_course_list[i++] = obj.getName();
            row_course_list[i++] = obj.getLang();
            row_course_list[i++] = obj.getLessons().getName();
            row_course_list[i++] = obj.getEducator().getName();
            mdl_course_list.addRow(row_course_list);

        }
    }


    private void loadLessonsMdl() {

        DefaultTableModel clearModel = (DefaultTableModel) tbl_lessons_list.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for(Lessons obj : Lessons.getList()){
            i=0;
            row_lessons_list[i++] = obj.getId();
            row_lessons_list[i++] = obj.getName();
            mdl_lessons_list.addRow(row_lessons_list);
        }

    }

    public  void loadUserModel(){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel();
        clearModel.setRowCount(0);

        for(User obj : User.getList()){
        int i = 0;

        row_user_list[i++] = obj.getIduser();
        row_user_list[i++] = obj.getName();
        row_user_list[i++] = obj.getUname();
        row_user_list[i++] = obj.getPass();
        row_user_list[i++] = obj.getTyp();
        mdl_user_list.addRow(row_user_list);

    }
}
    public  void loadUserModel(ArrayList<User> list){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel();
        clearModel.setRowCount(0);

        for(User obj : list){
            int i = 0;

            row_user_list[i++] = obj.getIduser();
            row_user_list[i++] = obj.getName();
            row_user_list[i++] = obj.getUname();
            row_user_list[i++] = obj.getPass();
            row_user_list[i++] = obj.getTyp();
            mdl_user_list.addRow(row_user_list);

        }
    }

     public  void  loadLessonsCombo(){
        cmb_course_lessons.removeAllItems();
        for (Lessons obj: Lessons.getList()){
            cmb_course_lessons.addItem(new Item( obj.getId(), obj.getName()));
        }
     }
     public  void loadEducatorCombo(){
        cmb_course_user.removeAllItems();
        for (User obj : User.getList()){
            if(obj.getTyp().equals("educator")){
                cmb_course_user.addItem(new Item(obj.getIduser(),obj.getName()));
            }
        }
     }

    public static void main(String[] args) {
        Operator op = new Operator();
        Helper.setLayout();


        OperatorGUI opGUI = new OperatorGUI(op);

    }

}
