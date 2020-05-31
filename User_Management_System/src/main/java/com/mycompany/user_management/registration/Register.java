/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.user_management.registration;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    RegistrationDatabaseModel newuser = new RegistrationDatabaseModel();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");

            newuser.setAdmin(request.getParameter("admin"));
            newuser.setFirstname(request.getParameter("firstname"));
            newuser.setLastname(request.getParameter("lastname"));
            newuser.setGender(request.getParameter("gender"));
            newuser.setPhonenumber(request.getParameter("phonenumber"));
            newuser.setUsername(request.getParameter("username"));
            newuser.setEmail(request.getParameter("email"));
            newuser.setPassword(request.getParameter("password"));
            newuser.setConfirmpassword(request.getParameter("confirmpassword"));

//            if (newuser.fieldIsEmpty()==true) {
//                out.print("Do not leave field empty");
//            } else 
            if (newuser.insertIntoAdminIsValid() == false) {
                out.println("<font color=red>Enter Y/N in Admin box.</font>");
                rd.include(request, response);
            } else if (newuser.insertIntoGenderIsValid() == false) {
                out.println("<font color=red>Enter Y/N in Gender box.</font>");
                rd.include(request, response);
            } else if (newuser.usernameDoesExist() == true) {
                out.println("<font color=red>Try another username " + newuser.getUsername() + " already exixts.</font>");
                rd.include(request, response);
            } else if (newuser.emailDoesExist() == true) {
                out.println("<font color=red>Try another email we can not take " + newuser.getEmail() + ".</font>");
                rd.include(request, response);
            } else if (newuser.emailDoesContainAatAndDot() == false) {
                out.println("<font color=red>E-mail is not valid.</font>");
                rd.include(request, response);
            } else if (newuser.passwordDoesExist() == true) {
                out.println("<font color=red>Try another password we can not take " + newuser.getPassword() + ".</font>");
                rd.include(request, response);
            } else if (newuser.passwordIsValid() == false) {
                out.println("<font color=red>Password must be 8 to 16 digit long and must contain uppercase, special character and number.</font>");
                rd.include(request, response);
            } else if (newuser.passwordAreSame() == false) {
                out.println("<font color=red>Passwords are not matching.</font>");
                rd.include(request, response);
            } else if (newuser.filledDataAreTooLong() == true) {
                out.println("<font color=red>Firstname, Lastname and Username must be less than 15 digits.</font>");
                rd.include(request, response);
            } else if (newuser.passwordIsSameAsUsername()==true) {
                out.println("<font color=red>Username and Password can not be same .</font>");
                rd.include(request, response);
            } else {
                newuser.addNewUser();
                response.sendRedirect("http://localhost:8080/User_Management/login/login.jsp");

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
