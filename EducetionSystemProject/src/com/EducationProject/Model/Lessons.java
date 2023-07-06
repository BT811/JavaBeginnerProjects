package com.EducationProject.Model;

import com.EducationProject.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Queue;

public class Lessons {
    private  int id ;
    private  String name;

    public Lessons(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static ArrayList<Lessons> getList(){
        ArrayList<Lessons> lessonsList = new ArrayList<>();
        Lessons obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lessons");
            while (rs.next()){
                obj = new Lessons(rs.getInt("id"),rs.getString("name"));
                lessonsList.add(obj);
            }
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return lessonsList;
    }

    public  static boolean add(String name){
        String query = "INSERT INTO lessons (name) values (?)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static  boolean update(int id, String name){
        String query = "UPDATE lessons SET name = ? WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setInt(2,id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean delete (int id){
        String query = "DELETE FROM lessons WHERE id = ?";
        ArrayList<Course> c = Course.getList();
        for(Course obj : c){
            if ( obj.getLessons().getId() == id){
                Course.delete(obj.getUser_id());
            }
        }

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Lessons getFetch(int id){

        Lessons obj = null;
        String query = "SELECT * FROM lessons WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj = new Lessons(rs.getInt("id"),rs.getString("name"));

            }
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return obj;
    }
}
