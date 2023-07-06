package com.EducationProject.Model;

import com.EducationProject.Helper.DBConnector;
import com.EducationProject.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Period;
import java.util.ArrayList;

public class User {
    private int iduser;
    private String name;
    private String uname;
    private String pass;
    private String typ;

    public User() {
        this.iduser = iduser;
        this.name = name;
        this.uname = uname;
        this.pass = pass;
        this.typ = typ;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTyp() {
        return typ;
    }

    public void setType(String typ) {
        this.typ = typ;
    }
    public static ArrayList<User> getList(){
        ArrayList<User> userList = new ArrayList<>();
        String query = "Select * FROM user";

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                User obj = new User();
                obj.setIduser(rs.getInt("iduser"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("Uname"));
                obj.setPass(rs.getString("Pass"));
                obj.setType(rs.getString("Typ"));
                userList.add(obj);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
    public static boolean add(String name, String uname, String pass, String typ ){
        String  query = "INSERT INTO user (name,uname,pass,typ) Values (?,?,?,?)";
        User findUser = User.getFetch(uname);
        if(findUser != null){
            Helper.showMsg("This username has been taken");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setString(2,uname);
            pr.setString(3,pass);
            pr.setString(4,typ);

            int respond = pr.executeUpdate();

            if(respond == -1){
                Helper.showMsg("error");
            }
            return respond != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return true;
    }

    public static User getFetch(String  uname){
        User obj = null;
        String query = "SELECT * FROM user WHERE uname = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,uname);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                obj = new User();
                obj.setIduser(rs.getInt("iduser"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("Uname"));
                obj.setPass(rs.getString("Pass"));
                obj.setType(rs.getString("Typ"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public static User getFetch(int iduser){
        User obj = null;
        String query = "SELECT * FROM user WHERE iduser = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,iduser);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                obj = new User();
                obj.setIduser(rs.getInt("iduser"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("typ"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public static boolean delete(int id){
        String query = "DELETE FROM user WHERE iduser = ? ";
        ArrayList<Course> courseL = Course.getListByUser(id);
        for(Course c : courseL){
            Course.delete(c.getUser_id());
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            return pr.executeUpdate() != -1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static  boolean update(int id, String  name, String uname, String pass, String type){
        String query = "UPDATE user SET name=?,uname=?,pass=?,typ=? WHERE iduser = ?";
        User findUser = User.getFetch(uname);
        if(findUser != null && findUser.getIduser() != id){
            Helper.showMsg("This username has been taken");
            return false;
        }
        if(!type.equals("operator") && !type.equals("student") && !type.equals("educator")){
            Helper.showMsg("This part can be operator - student - educator only");
            return false;
        }

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setString(2,uname);
            pr.setString(3,pass);
            pr.setString(4,type);
            pr.setInt(5,id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  static ArrayList<User> searchUserList(String query){
        ArrayList<User> userList = new ArrayList<>();

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                User obj = new User();
                obj.setIduser(rs.getInt("iduser"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("Uname"));
                obj.setPass(rs.getString("Pass"));
                obj.setType(rs.getString("Typ"));
                userList.add(obj);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public static String searchQuery(String name, String uname, String type){
        String query ="SELECT * FROM user WHERE uname LIKE '%{{uname}}%' AND name LIKE '%{{name}}%' AND typ LIKE '%{{type}}%'";
        query = query.replace("{{uname}}",uname);
        query = query.replace("{{name}}",name);
        query = query.replace("{{type}}",type);
        return query;
    }
    public static User getFetch(String uname , String pass){
        User obj = null;
        String query = "SELECT * FROM user WHERE uname = ? AND pass = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,uname);
            pr.setString(2,pass);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                switch (rs.getString("typ")){
                    case "operator":
                        obj = new Operator();
                        break;
                    default:
                        obj = new User();
                }

                obj.setIduser(rs.getInt("iduser"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("typ"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
}
