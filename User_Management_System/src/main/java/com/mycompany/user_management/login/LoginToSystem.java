/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.user_management.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
=======
import java.time.LocalDateTime;
>>>>>>> 78cce0831d3b822d2bb8fef0a2d705d2c0a4f087
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
<<<<<<< HEAD
=======
import static jspcrud.UserDao.getAdmin;
>>>>>>> 78cce0831d3b822d2bb8fef0a2d705d2c0a4f087

/**
 *
 * @author Asus
 */
public class LoginToSystem extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
<<<<<<< HEAD
            RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/login.jsp");
                
=======
            
            HttpSession session = request.getSession();
>>>>>>> 78cce0831d3b822d2bb8fef0a2d705d2c0a4f087
            String loginemail = request.getParameter("loginemail");
            String loginpassword = request.getParameter("loginpassword");
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursework?serverTimezone=UTC","root","");
            String Sql_Query = "select * from users where (email = ? and password = ?) or (username = ? and password = ?)";
            
            PreparedStatement Pre_Stat = conn.prepareStatement(Sql_Query);
            Pre_Stat.setString(1, loginemail);
            Pre_Stat.setString(2, loginpassword);
            Pre_Stat.setString(3, loginemail);
            Pre_Stat.setString(4, loginpassword);
            ResultSet r1 = Pre_Stat.executeQuery();
            
            if(r1.next()==true) {
                HttpSession SessionID = request.getSession();
                SessionID.setAttribute("loginemail", loginemail);
<<<<<<< HEAD
                response.sendRedirect("http://localhost:8080/User_Management/homepage.jsp");
//                RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginSuccess.jsp");
//                rd.include(request, response);
            }else {
                out.println("<font color=red>Username or Password is not correct.</font>");
=======
                
                if (jspcrud.UserDao.getAdmin(loginemail)=="Y"&&jspcrud.UserDao.get_blocked_status(loginemail)=="No") {
                    session.setAttribute("Username", loginemail);
                    String action = "Logged in to the system";
                    String time = LocalDateTime.now().toString();

                    History.History h = new History.History(loginemail,time, action);//History instance

                    History.HistoryDao.addHistory(h);

                    response.sendRedirect("http://localhost:8080/User_Management_System/homepage.jsp");
                }
                else if (jspcrud.UserDao.getAdmin(loginemail)=="N"&&jspcrud.UserDao.get_blocked_status(loginemail)=="No") {
                    session.setAttribute("Username", loginemail);
                    String action = "Logged in to the system";
                    String time = LocalDateTime.now().toString();

                    History.History h = new History.History(loginemail,time, action);//History instance

                    History.HistoryDao.addHistory(h);
                      
                    response.sendRedirect("http://localhost:8080/User_Management_System/Homepage2.jsp");
                }
               else if (jspcrud.UserDao.get_blocked_status(loginemail)=="Yes") {
                    RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/login.jsp");
                out.println("<font color=red> You are blocked. Please contact admin</font>");
                rd1.include(request, response);
                }
            }else {
                RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/login.jsp");
                out.println("<font color=red>Username or Password is not correct or you may be blocked. Please contact admin</font>");
>>>>>>> 78cce0831d3b822d2bb8fef0a2d705d2c0a4f087
                rd1.include(request, response);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginToSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginToSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginToSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginToSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
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
