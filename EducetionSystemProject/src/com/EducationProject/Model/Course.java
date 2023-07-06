package com.EducationProject.Model;

import com.EducationProject.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Course {
    private int id;
    private int user_id;
    private int lessons_id;
    private String name;
    private String lang;
    private Lessons lessons;
    private User educator;
    public Course(int id, int user_id, int lessons_id, String name, String lang){
        this.id = id;
        this.user_id = user_id;
        this.lessons_id = lessons_id;
        this.name = name;
        this.lang = lang;
        this.lessons = Lessons.getFetch(lessons_id);
        this.educator = User.getFetch(user_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getLessons_id() {
        return lessons_id;
    }

    public void setLessons_id(int lessons_id) {
        this.lessons_id = lessons_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Lessons getLessons() {
        return lessons;
    }

    public void setLessons(Lessons lessons) {
        this.lessons = lessons;
    }

    public User getEducator() {
        return educator;
    }

    public void setEducator(User educator) {
        this.educator = educator;
    }
    public  static ArrayList<Course> getList(){
        ArrayList<Course> courseList = new ArrayList<>();
        Course obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM course");
            while(rs.next()){
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                int lessons_id = rs.getInt("lessons_id");
                String name = rs.getString("name");
                String lang = rs.getString("lang");
                obj = new Course(id,user_id,lessons_id,name,lang);

                courseList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courseList;
    }
    public  static ArrayList<Course> getListByUser(int user_id){
        ArrayList<Course> courseList = new ArrayList<>();
        Course obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM course WHERE user_id = "+user_id);
            while(rs.next()){
                int id = rs.getInt("id");
                int userID = rs.getInt("user_id");
                int lessons_id = rs.getInt("lessons_id");
                String name = rs.getString("name");
                String lang = rs.getString("lang");
                obj = new Course(id,userID ,lessons_id,name,lang);

                courseList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courseList;
    }
    public  static boolean add(int user_id, int lessons_id,String  name, String lang){
        String query = "INSERT INTO course (user_id,lessons_id,name,lang) VALUES (?,?,?,?)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,user_id);
            pr.setInt(2,lessons_id);
            pr.setString(3,name);
            pr.setString(4,lang);
            return  pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean delete(int id){
        String query = "DELETE FROM course WHERE user_id = ? ";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            return pr.executeUpdate() != -1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
