package Database.Create;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void CreateTableDB(Connection conn){
        try (Statement stmt = conn.createStatement()) {
            try{
                stmt.executeUpdate(CreateTicket());
                System.out.println("Create table ticket success!");
            }catch (Exception e) {
                stmt.executeUpdate(DeleteTable("ticket"));
                System.out.println("Delete table ticket success!");
                stmt.executeUpdate(CreateTicket());
                System.out.println("Create table ticket success!");
            }
            try{
                stmt.executeUpdate(CreateTableUser());
                System.out.println("Create table user success!");
            }catch (Exception e) {
                stmt.executeUpdate(DeleteTable("userSystem"));
                System.out.println("Delete table user success!");
                stmt.executeUpdate(CreateTableUser());
                System.out.println("Create table user success!");
            }
            try{
                stmt.executeUpdate(CreateDate());
                System.out.println("Create table date success!");
            }catch (Exception e) {
                stmt.executeUpdate(DeleteTable("date"));
                System.out.println("Delete table date success!");
                stmt.executeUpdate(CreateDate());
                System.out.println("Create table date success!");
            }
            try{
                stmt.executeUpdate(CreateFilm());
                System.out.println("Create table film success!");
            }catch (Exception e) {
                stmt.executeUpdate(DeleteTable("film"));
                System.out.println("Delete table film success!");
                stmt.executeUpdate(CreateFilm());
                System.out.println("Create table film success!");
            }
            try{
                stmt.executeUpdate(CreateRoom());
                System.out.println("Create table room success!");
            }catch (Exception e) {
                stmt.executeUpdate(DeleteTable("room"));
                System.out.println("Delete table room success!");
                stmt.executeUpdate(CreateRoom());
                System.out.println("Create table room success!");
            }
            try {
                stmt.executeUpdate(CreateFK("userSystem", "ticket", "id", "userId"));
                stmt.executeUpdate(CreateFK("date", "ticket", "id", "timeId"));
                stmt.executeUpdate(CreateFK("film", "date", "id", "filmId"));
                stmt.executeUpdate(CreateFK("room", "date", "id", "roomId"));
                System.out.println("Create FOREIGN KEY success!");
            }catch (Exception e){
                System.out.println(e);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    static String CreateTableUser(){
        return  "create table userSystem(id int primary key, username varchar(50), password varchar(50), fullname varchar(50), gender int, birthday date, type int)";
    }
    static String CreateTicket(){
        return "create table ticket(id int primary key, userId int, timeId int, rowTicket int, columnTicket int)";
    }
    static String CreateFilm(){
        return "create table film(id int primary key, name varchar(100), time int)";
    }
    static String CreateDate(){
        return "create table date(id int primary key, roomId int, filmId int, soldOut int, time varchar(10), date date)";
    }
    static String CreateRoom(){
        return "create table room(id int primary key, name varchar(50))";
    }
    static String CreateFK(String tablef, String tablet, String comlumf, String comlumt){
        return "ALTER TABLE " + tablet+ "\nADD CONSTRAINT "+tablef+"_"+tablet+"\n  FOREIGN KEY ("+ comlumt + ")\n" + "  REFERENCES "+tablef+" ("+comlumf+");";
    }
    static String DeleteTable(String table){
        return "drop table "+table;
    }
}
