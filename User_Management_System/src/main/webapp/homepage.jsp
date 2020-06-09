<%@page import="java.util.List"%>
<%@page import="jspcrud.UserDao"%>
<%@page import="jspcrud.User"%>
 <% if(session.getAttribute("loginemail")==null){
        request.setAttribute("message", "You need to be logged in !!");
        response.sendRedirect("login/login.jsp");
    }
    %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>UMS Admin  Dashboard</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
                  <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-laugh-wink"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">Admin Dashboard</div>
                </a>

                


               
              
<li class="nav-item">
     
                 <a class="nav-link collapsed" href="viewusers.jsp">View User</a>  
                </li>
                <li class="nav-item">
                 <a class="nav-link collapsed" href="adduserform.jsp">Add User</a>  
                </li>
                <li class="nav-item">
                 <a class="nav-link collapsed" href="Allhistory.jsp">History</a>  
                </li>
                <li class="nav-item">
                 <a class="nav-link collapsed" href="Report.jsp">Report</a>  
                </li>
                <li class="nav-item">
                <a class="nav-link collapsed" href="/User_Management_System/User_Profile?uname=${loginemail}">
                Profile</a>
                </li>
                <li class="nav-item" >
                    <a class="nav-link collapsed" href="logout.jsp">Logout</a>
                </li>


                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            
                            <i class="fa fa-bars"></i>
                        </button>



                    </nav>
                    <!-- End of Topbar -->

                  


                    <main>
                        <form>
                            <div class="container-fluid">
                                <h1 class="mt-4">Dashboard</h1>

                                
                                <div class="card mb-4">
                                    
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <%
                                         List<User> list=UserDao.getAllRecords();
                                         request.setAttribute("list",list);
                                                                           %>
                                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                                <thead>
                                                    <tr>
                                                       <th>Is Admin</th>
                                                        <th>First Name</th>
                                                        <th>Last name</th>
                                                        <th>Username</th>
                                                        <th>Email</th>
                                                        <th>Gender</th>
                                                        <th>Phone Number</th>
                                                        <th>Created time</th>

                                                    </tr>
                                                    <c:forEach items="${list}" var="u">
	<tr><td>${u.getAdmin()}</td><td>${u.getFirstName()}</td><td>${u.getLastName()}</td><td>${u.getUsername()}</td><td>${u.getEmail()}</td>
            <td>${u.getGender()}</td><td>${u.getPhonenumber()}</td><td>${u.getCreatedDate()}</td></tr>
</c:forEach>
                                                </thead>
                                                
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </main>




                    <!-- /.container-fluid -->


                    <!-- End of Main Content -->

                    <!-- Footer -->
                    <footer class="sticky-footer bg-white">
                        <div class="container my-auto">
                            <div class="copyright text-center my-auto">
                                <span>Copyright &copy; User Management System 2020</span>
                            </div>
                        </div>
                    </footer>
                    <!-- End of Footer -->

                </div>
                <!-- End of Content Wrapper -->

            </div>
            <!-- End of Page Wrapper -->

            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fas fa-angle-up"></i>
            </a>

            <!-- Logout Modal-->
            <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">�</span>
                            </button>
                        </div>
                        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                        <div class="modal-footer">
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                            <a class="btn btn-primary" href="/User-Management-System/Logout">Logout</a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Bootstrap core JavaScript-->
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="js/sb-admin-2.min.js"></script>

            <!-- Page level plugins -->
            <script src="vendor/chart.js/Chart.min.js"></script>

            <!-- Page level custom scripts -->
            <script src="js/demo/chart-area-demo.js"></script>
            <script src="js/demo/chart-pie-demo.js"></script>

            <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
            <script src="js/scripts.js"></script>
            <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
            <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
            <script src="js/demo/datatables-demo.js"></script>

    </body>

</html>

