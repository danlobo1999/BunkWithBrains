package controllers;

import sample.DBConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Functions {
    private static LocalDate displayDate;
    private static String username;
    static String name;
    static int rollno;
    static int pid;
    static int userkey;

    public static int am, amt, dlda, dldap, das, dasp, eccf, eccfp, oopm, oopmp, dim;

    public static void setSelectedDate(LocalDate d){
        displayDate = d;
    }

    public static void getUser(String u){
        username=u;
        String query = "SELECT * FROM `users` WHERE `username`='%s'";
        query=String.format(query,username);
        try {
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            if(set.next()){
                name=set.getString("name");
                rollno=set.getInt("rollno");
                pid=set.getInt("pid");
                userkey=set.getInt("uid");
            }
        }
        catch (SQLException  e){
            e.printStackTrace();
        }
    }

    public static String dateConverter(){
        String date;
        LocalDate localDate = displayDate;
        java.sql.Date dat = java.sql.Date.valueOf(localDate);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        date = df.format(dat);
        return date;
    }

    public static String dateprinter(){
        String date;
        LocalDate localDate = displayDate;
        java.sql.Date dat = java.sql.Date.valueOf(localDate);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        date = df.format(dat);
        return date;
    }

    public static int attendedam(){
        int att = 0;
        String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && `am3`=1";
        query = String.format(query,Functions.userkey);
        try{
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                att++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return att;
    }

    public static int totalam(){
        int t=0;

        try{
            String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && (`am3`=1 || `am3`=0)";
            query = String.format(query,Functions.userkey);
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                t++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
       return t;
    }

    public static int attendedamt(){
        int att = 0;
        String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && `amt`=1";
        query = String.format(query,Functions.userkey);
        try{
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                att++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return att;
    }

    public static int totalamt(){
        int t = 0;
        try{
            String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && (`amt`=1 || `amt`=0)";
            query = String.format(query,Functions.userkey);
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                t++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return t;
    }

    public static int attendeddlda(){
        int att = 0;
        String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && `dlda`=1";
        query = String.format(query,Functions.userkey);
        try{
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                att++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return att;
    }

    public static int totaldlda(){
        int t = 0;
        try{
            String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && (`dlda`=1 || `dlda`=0)";
            query = String.format(query,Functions.userkey);
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                t++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return t;
    }

    public static int attendeddldap(){
        int att = 0;
        String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && `dldap`=1";
        query = String.format(query,Functions.userkey);
        try{
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                att++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return att;
    }

    public static int totaldldap(){
        int t = 0;
        try{
            String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && (`dldap`=1 || `dldap`=0)";
            query = String.format(query,Functions.userkey);
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                t++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return t;
    }

    public static int attendeddas(){
        int att = 0;
        String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && `das`=1";
        query = String.format(query,Functions.userkey);
        try{
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                att++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return att;
    }

    public static int totaldas(){
        int t = 0;
        try{
            String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && (`das`=1 || `das`=0)";
            query = String.format(query,Functions.userkey);
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                t++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return t;
    }

    public static int attendeddasp(){
        int att = 0;
        String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && `dasp`=1";
        query = String.format(query,Functions.userkey);
        try{
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                att++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return att;
    }

    public static int totaldasp(){
        int t = 0;
        try{
            String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && (`dasp`=1 || `dasp`=0)";
            query = String.format(query,Functions.userkey);
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                t++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return t;
    }

    public static int attendedeccf(){
        int att = 0;
        String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && `eccf`=1";
        query = String.format(query,Functions.userkey);
        try{
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                att++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return att;
    }

    public static int totaleccf(){
        int t = 0;
        try{
            String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && (`eccf`=1 || `eccf`=0)";
            query = String.format(query,Functions.userkey);
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                t++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return t;
    }

    public static int attendedeccfp(){
        int att = 0;
        String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && `eccfp`=1";
        query = String.format(query,Functions.userkey);
        try{
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                att++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return att;
    }

    public static int totaleccfp(){
        int t = 0;
        try{
            String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && (`eccfp`=1 || `eccfp`=0)";
            query = String.format(query,Functions.userkey);
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                t++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return t;
    }

    public static int attendedoopm(){
        int att = 0;
        String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && `oopm`=1";
        query = String.format(query,Functions.userkey);
        try{
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                att++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return att;
    }

    public static int totaloopm(){
        int t = 0;
        try{
            String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && (`oopm`=1 || `oopm`=0)";
            query = String.format(query,Functions.userkey);
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                t++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return t;
    }

    public static int attendedoopmp(){
        int att = 0;
        String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && `oopmp`=1";
        query = String.format(query,Functions.userkey);
        try{
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                att++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return att;
    }

    public static int totaloopmp(){
        int t = 0;
        try{
            String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && (`oopmp`=1 || `oopmp`=0)";
            query = String.format(query,Functions.userkey);
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                t++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return t;
    }

    public static int attendeddim(){
        int att = 0;
        String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && `dim`=1";
        query = String.format(query,Functions.userkey);
        try{
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                att++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return att;
    }

    public static int totaldim(){
        int t = 0;
        try{
            String query = "SELECT * FROM `dvs` WHERE `userkey`='%d' && (`dim`=1 || `dim`=0)";
            query = String.format(query,Functions.userkey);
            ResultSet set = DBConnect.getStatement().executeQuery(query);
            while (set.next()) {
                t++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return t;
    }

    public static float average(int n, int m){
        float avg=0;
        avg =  ((float) n/(float)m)*100;
        return avg;
    }

    public static void bunkAssign(int am1, int amt1, int dlda1, int dldap1, int das1, int dasp1, int eccf1, int eccfp1, int oopm1, int oopmp1, int dim1){
        am=am1;
        amt=amt1;
        dlda=dlda1;
        dldap=dldap1;
        das=das1;
        dasp=dasp1;
        eccf=eccf1;
        eccfp=eccfp1;
        oopm=oopm1;
        oopmp=oopmp1;
        dim=dim1;
        System.out.println(dim);
    }
}
