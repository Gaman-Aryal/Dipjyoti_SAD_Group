/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.user_management.registration;

<<<<<<< HEAD
=======
import java.io.UnsupportedEncodingException;
>>>>>>> 78cce0831d3b822d2bb8fef0a2d705d2c0a4f087
import static java.lang.Character.isUpperCase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.logging.Level;
import java.util.logging.Logger;
=======
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
>>>>>>> 78cce0831d3b822d2bb8fef0a2d705d2c0a4f087

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
<<<<<<< HEAD
=======
    private String created_date;
    private String blocked_status;
>>>>>>> 78cce0831d3b822d2bb8fef0a2d705d2c0a4f087

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

<<<<<<< HEAD
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
=======
    public String getCreatedDate() {
        return created_date;
    }

    public void setCreatedDate(String created_date) {
        this.created_date = created_date;
    }

    public String getBlockedStatus() {
        return blocked_status;
    }

    public void setBlockedStatus(String blocked_status) {
        this.blocked_status = blocked_status;
    }
    

    public String insertIntoAdminIsValid() {
        String str = admin;
        String checked = "error";
>>>>>>> 78cce0831d3b822d2bb8fef0a2d705d2c0a4f087

        for (int i = 0; i < str.length(); i++) {

            //Checks whether a filled contain y or not   
            if (str.charAt(i) == 'y' || str.charAt(i) == 'Y') {
<<<<<<< HEAD
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
=======
                setAdmin("No");
                checked = "ok";

                //Checks whether a filled contain n or not
            } else if (str.charAt(i) == 'N' || str.charAt(i) == 'n') {
                setAdmin("No");
                checked = "notok";
            }
        }

        return checked;

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

>>>>>>> 78cce0831d3b822d2bb8fef0a2d705d2c0a4f087
        return checked;

    }

<<<<<<< HEAD
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
=======
>>>>>>> 78cce0831d3b822d2bb8fef0a2d705d2c0a4f087
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

<<<<<<< HEAD
            String Sql_query = "insert into users (Admin,Firstname,Lastname,Gender,Phonenumber,Username,Email,Password) values (?,?,?,?,?,?,?,?)";
=======
            String Sql_query = "insert into users (Admin,Firstname,Lastname,Gender,Phonenumber,Username,Email,Password,Created_date,Blocked_Status) values (?,?,?,?,?,?,?,?,?,?)";
>>>>>>> 78cce0831d3b822d2bb8fef0a2d705d2c0a4f087
            PreparedStatement Pre_Stat = conn.prepareStatement(Sql_query);
            Pre_Stat.setString(1, admin);
            Pre_Stat.setString(2, firstname);
            Pre_Stat.setString(3, lastname);
            Pre_Stat.setString(4, gender);
            Pre_Stat.setString(5, phonenumber);
            Pre_Stat.setString(6, username);
            Pre_Stat.setString(7, email);
            Pre_Stat.setString(8, password);
<<<<<<< HEAD
=======
            Pre_Stat.setString(9, created_date);
            Pre_Stat.setString(10, blocked_status);
>>>>>>> 78cce0831d3b822d2bb8fef0a2d705d2c0a4f087

            Pre_Stat.execute();
            Pre_Stat.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RegistrationDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

<<<<<<< HEAD
=======
    public void generateCodeAndSendItToSeniourAdmin() throws ClassNotFoundException, SQLException, UnsupportedEncodingException, MessagingException {

        String[] AdminsEmail = {"gamanaryal@gmail.com","gauravraut305@gmail.com" , "jitenghi9@gmail.com", "melonchhetri@gmail.com"};
        Random randomadmin = new Random();
        int randomadminmin = 0;
        int randomadminmax = 3;
        int randomadminresult = randomadmin.nextInt(randomadminmax - randomadminmin) + randomadminmin;

        String str = "";

        Random r = new Random();
        int min = 100000000;
        int max = 1000000000;
        int res = r.nextInt(max - min) + min;

        for (int i = 0; i <= 4; i++) {
            //checks that the last two digits fall under the ASCII number
            int remainder = res % 100;
            if ((remainder >= 63) && (remainder <= 90) || (remainder >= 35) && (remainder <= 38) || (remainder >= 97) && (remainder <= 122)) {

                str = Character.toString((char) remainder) + str;
            } else {
                str = Integer.toString(remainder) + str;
            }
            res = (res - (remainder % 10)) / 100;
        }

        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework?serverTimezone=UTC", "root", "")) {
            String Sql_Query = "update adminverificationcode set code=? , email=? , emailreceiveradminemail=? where serial=1";
            PreparedStatement Pre_Stat = conn.prepareStatement(Sql_Query);
            Pre_Stat.setString(1, str);
            Pre_Stat.setString(2, email);
            Pre_Stat.setString(3, AdminsEmail[randomadminresult]);
            Pre_Stat.executeUpdate();
        }

        String Mail_Subject = "New Admin Registration";
        String Mail_Content = "<h1> Here is the code for the New Admin Registration :-<b> " + str + "</b></h1><br><h3> Name :- " + firstname + " " + lastname + " <br> Email :- " + email + "</h3>";

        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("usermanagementsystem123@gmail.com", "Management@123");
            }
        });

        // creates a new e-mail message
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress("usermanagementsystem123@gmail.com", "User Management System"));
        InternetAddress[] toAddresses = {new InternetAddress(AdminsEmail[randomadminresult])};
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(Mail_Subject);
        msg.setContent(Mail_Content, "text/html");

        // sends the e-mail
        Transport.send(msg);

    }
>>>>>>> 78cce0831d3b822d2bb8fef0a2d705d2c0a4f087
}
