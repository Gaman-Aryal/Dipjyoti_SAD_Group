/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.user_management.updatepassword;

import com.mycompany.user_management.forgotpassword.MailProcess;
import com.mycompany.user_management.registration.RegistrationDatabaseModel;
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
public class UpdatePasswordDatabaseModel {

    private String Checkemail;
    private String oldPassword;
    private String Updatepassword;
    private String Updateconfirmpassword;
    
    public String getUpdatepassword() {
        return Updatepassword;
    }

    public void setUpdatepassword(String Updatepassword) {
        this.Updatepassword = Updatepassword;
    }

    public void setUpdateconfirmpassword(String Updateconfirmpassword) {
        this.Updateconfirmpassword = Updateconfirmpassword;
    }

    public void setCheckemail(String Checkemail) {
        this.Checkemail = Checkemail;
    }

    public boolean boxesAreEmpty() {
        Boolean checked = true;
        if ((Checkemail.isEmpty() == false) && (Updatepassword.isEmpty() == false) && (Updateconfirmpassword.isEmpty() == false)) {
            checked = false;
        }
        return checked;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
    

    public boolean UsernameOrPasswordAsSameAsEnteredPasswordDoesExist() {
        Boolean checked = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework?serverTimezone=UTC", "root", "");
            String Sql_Query = "select * from users where username = ? or password = ?";

            PreparedStatement Pre_Stat = conn.prepareStatement(Sql_Query);
            Pre_Stat.setString(1, Updatepassword);
            Pre_Stat.setString(1, Updatepassword);
            ResultSet r1 = Pre_Stat.executeQuery();

            if (r1.next()) {
                checked = true;
            } else {
                checked = false;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegistrationDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checked;
    }
        public static boolean OldPasswordIsCorrect(String oldPassword, String username) {
        Boolean status= false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework?serverTimezone=UTC", "root", "");
            String Sql_Query = "select Paaaword from users where Username = ?";
        
        PreparedStatement ps = conn.prepareStatement(Sql_Query);
        
        ps.setString(1,username);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            String pass = rs.getString("Password");
            
            if(oldPassword.equals(pass)){
                status=false;
            }
            else{
                status=true;
            }
        }
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegistrationDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
  

    public boolean enteredEmailIsGenuine() {
        Boolean checked = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework?serverTimezone=UTC", "root", "");
            String Sql_Query = "select * from resetpasswordrecord where email = ?";

            PreparedStatement Pre_Stat = conn.prepareStatement(Sql_Query);
            Pre_Stat.setString(1, Checkemail);
            ResultSet r1 = Pre_Stat.executeQuery();

            if (r1.next()) {
                checked = true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegistrationDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checked;
    }

    public boolean passwordsAreSame() {
        Boolean checked;

        //Checks whether a password are same or not
        if (Updatepassword.equals(Updateconfirmpassword)) {
            checked = true;
        } else {
            checked = false;
        }
        return checked;
    }

    public boolean passwordIsValid() {
        String str = Updatepassword;
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

    public void updatePassword() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
<<<<<<< HEAD
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework?serverTimezone=UTC", "root", "");

            String Sql_Query = "update users set password = ? where email=?";
            PreparedStatement Pre_Stat = conn.prepareStatement(Sql_Query);
            Pre_Stat.setString(1, Updatepassword);
            Pre_Stat.setString(2, Checkemail);
            Pre_Stat.executeUpdate();
            conn.close();
=======
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework?serverTimezone=UTC", "root", "")) {
                String Sql_Query = "update users set password = ? where email=?";
                PreparedStatement Pre_Stat = conn.prepareStatement(Sql_Query);
                Pre_Stat.setString(1, Updatepassword);
                Pre_Stat.setString(2, Checkemail);
                Pre_Stat.executeUpdate();
            }
>>>>>>> 78cce0831d3b822d2bb8fef0a2d705d2c0a4f087
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdatePasswordDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void changePassword() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework?serverTimezone=UTC", "root", "")) {
                String Sql_Query = "update users set password = ? where username=?";
                PreparedStatement Pre_Stat = conn.prepareStatement(Sql_Query);
                Pre_Stat.setString(1, Updatepassword);
                Pre_Stat.setString(2, Checkemail);
                Pre_Stat.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdatePasswordDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setBackToNormal(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework?serverTimezone=UTC", "root", "");
            
            String Sql_Query = "update resetpasswordrecord set code=? , email=?  where serial=1";
            PreparedStatement Pre_Stat = conn.prepareStatement(Sql_Query);
            Pre_Stat.setString(1, "");
            Pre_Stat.setString(2, "");
            Pre_Stat.executeUpdate();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdatePasswordDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
