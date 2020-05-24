/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.user_management.registration;

import static java.lang.Character.isUpperCase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class RegistrationDatabaseModel {

    private String admin;
    private String firstname;
    private String lastname;
    private String gender;
    private String phonenumber;
    private String username;
    private String email;
    private String password;
    private String confirmpassword;

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public boolean filledDataAreTooLong() {
        Boolean checked = true;
        String[] Array = new String[]{firstname, lastname, username};
        int[] Count = new int[]{0, 0, 0};

        for (int i = 0; i < 3; i++) {
            String str = Array[i];
            for (int j = 0; j < str.length(); j++) {
                Count[i]++;
            }
        }
        if (Count[0] <= 20 && Count[1] <= 20 && Count[2] <= 40) {
            checked = false;
        }

        return checked;

    }

    public boolean insertIntoAdminIsValid() {
        String str = admin;
        Boolean checked = false;
        int NumberOfdigit = 0;

        for (int i = 0; i < str.length(); i++) {

            //Checks whether a filled contain y or not   
            if (str.charAt(i) == 'y' || str.charAt(i) == 'Y') {
                setAdmin("Yes");
                NumberOfdigit++;

                //Checks whether a filled contain n or not
            } else if (str.charAt(i) == 'n' || str.charAt(i) == 'N') {
                setAdmin("No");
                NumberOfdigit++;

            } else {
                checked = false;
            }
        }

        if (NumberOfdigit == 1) {
            checked = true;
        }
        return checked;

    }

//    public boolean phoneNumberIsValid(){
//        String str = phonenumber;
//        Boolean checked = false;
//        int NumberOfvaliddigit=0;
//        
//        for(int i = 0; i <= str.length(); i++) {  
//            //Converting character into ASCII number            
//            int ascii = str.charAt(i);
//            //Checks whether phonenumber is valid or not    
//            if((ascii>=48 && ascii<=57)) { 
//                NumberOfvaliddigit++;
//            }
//        }
//        if(NumberOfvaliddigit ==10){
//            checked = true;
//        }
//        return checked;
//    } 
//    
    public boolean insertIntoGenderIsValid() {
        String str = gender;
        Boolean checked = false;
        int NumberOfdigit = 0;

        for (int i = 0; i < str.length(); i++) {

            //Checks whether a filled contain y or not   
            if (str.charAt(i) == 'm' || str.charAt(i) == 'M') {
                setGender("Male");
                NumberOfdigit++;

                //Checks whether a filled contain n or not
            } else if (str.charAt(i) == 'f' || str.charAt(i) == 'F') {
                setGender("Female");
                NumberOfdigit++;

            } else if (str.charAt(i) == 'o' || str.charAt(i) == 'O') {
                setGender("Others");
                NumberOfdigit++;

            } else {
                checked = false;
            }
        }

        if (NumberOfdigit == 1) {
            checked = true;
        }
        return checked;

    }

    public boolean usernameDoesExist() {
        Boolean checked = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework?serverTimezone=UTC", "root", "");
            String Sql_Query = "select * from users where username = ?";

            PreparedStatement Pre_Stat = conn.prepareStatement(Sql_Query);
            Pre_Stat.setString(1, username);
            ResultSet r1 = Pre_Stat.executeQuery();

            if (r1.next()) {
                checked = true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegistrationDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checked;
    }

    public boolean emailDoesExist() {
        Boolean checked = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework?serverTimezone=UTC", "root", "");
            String Sql_Query = "select * from users where Email = ?";

            PreparedStatement Pre_Stat = conn.prepareStatement(Sql_Query);
            Pre_Stat.setString(1, email);
            ResultSet r1 = Pre_Stat.executeQuery();

            if (r1.next()) {
                checked = true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegistrationDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checked;
    }

    public boolean emailDoesContainAatAndDot() {
        String str = email;
        Boolean checked;
        int a = 0;

        for (int i = 0; i < str.length(); i++) {
            //Checks whether a password contain special character or not    
            if (str.charAt(i) == '@' || str.charAt(i) == '.') {
                a++;
            }
        }

        if (a == 2) {
            checked = true;
        } else {
            checked = false;
        }
        return checked;

    }

    public boolean passwordDoesExist() {
        Boolean checked = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework?serverTimezone=UTC", "root", "");
            String Sql_Query = "select * from users where Password = ?";

            PreparedStatement Pre_Stat = conn.prepareStatement(Sql_Query);
            Pre_Stat.setString(1, password);
            ResultSet r1 = Pre_Stat.executeQuery();

            if (r1.next()) {
                checked = true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegistrationDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checked;
    }

    public boolean passwordIsValid() {
        String str = password;
        Boolean checked;
        int NumberOfUpperCase = 0;
        int NumberOfSpecialCharacter = 0;
        int NumberOfnumbers = 0;
        int NumberOfdigit = 0;

        for (int i = 0; i < str.length(); i++) {

            int ascii = (int) str.charAt(i);

            //Checks whether a password contain special character or not   
            if (str.charAt(i) == '.' || str.charAt(i) == '!' || str.charAt(i) == '@' || str.charAt(i) == '#' || str.charAt(i) == '$' || str.charAt(i) == '%' || str.charAt(i) == '^' || str.charAt(i) == '&' || str.charAt(i) == '*') {
                NumberOfSpecialCharacter++;

                //Checks whether a password contain uppercase or not
            } else if (isUpperCase(str.charAt(i)) == true) {
                NumberOfUpperCase++;

                //Checks whether a password contain number or not
            } else if ((ascii >= 48 && ascii <= 57)) {
                NumberOfnumbers++;
            }
            NumberOfdigit++;
        }

        if ((NumberOfSpecialCharacter > 0) && (NumberOfUpperCase > 0) && (NumberOfnumbers > 0) && ((NumberOfdigit > 8) && (NumberOfdigit < 16))) {
            checked = true;
        } else {
            checked = false;
        }
        return checked;
    }

    public boolean passwordIsSameAsUsername() {
        Boolean checked;

        //Checks whether a password are same or not
        if (password.equals(username)) {
            checked = true;
        } else {
            checked = false;
        }
        return checked;
    }

    public boolean passwordAreSame() {
        Boolean checked;

        //Checks whether a password are same or not
        if (password.equals(confirmpassword)) {
            checked = true;
        } else {
            checked = false;
        }
        return checked;
    }

    public void addNewUser() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework?serverTimezone=UTC", "root", "");

            String Sql_query = "insert into users (Admin,Firstname,Lastname,Gender,Phonenumber,Username,Email,Password) values (?,?,?,?,?,?,?,?)";
            PreparedStatement Pre_Stat = conn.prepareStatement(Sql_query);
            Pre_Stat.setString(1, admin);
            Pre_Stat.setString(2, firstname);
            Pre_Stat.setString(3, lastname);
            Pre_Stat.setString(4, gender);
            Pre_Stat.setString(5, phonenumber);
            Pre_Stat.setString(6, username);
            Pre_Stat.setString(7, email);
            Pre_Stat.setString(8, password);

            Pre_Stat.execute();
            Pre_Stat.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RegistrationDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
