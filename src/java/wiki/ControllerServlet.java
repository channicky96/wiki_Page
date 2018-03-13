package wiki;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
<<<<<<< HEAD
import java.util.logging.Level;
import java.util.logging.Logger;
=======
>>>>>>> 534c71743fe16eeef46b1fe14360d8afdef306ba

/**
 *
 * @author acc16scu
 */
@WebServlet(name = "ControllerServlet", urlPatterns = {"/ControllerServlet"})
public class ControllerServlet extends HttpServlet {


//    public ControllerServlet() throws SQLException {
        //java.sql.Connection connectionUrl = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres"); //8084?
//    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
<<<<<<< HEAD
        String nickname = request.getParameter("nickname");
        String confirmpassword = request.getParameter("password1");
        String email = request.getParameter("useremail");
        String button = request.getParameter("button");
        if(button.equals("login")){
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            request.setAttribute("TEST", user);

            boolean status = user.validate(username);

            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ControllerServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                if (status){
                   //out.println("<script>alert(\"Hello\\nSUCESS\");</script>");
                   RequestDispatcher rd = request.getRequestDispatcher("login_success.jsp");
                   rd.forward(request, response);
                }
                else{
                    //out.println("<script>alert(\"Hello\\nFAIL\");</script>");
                    RequestDispatcher rd = request.getRequestDispatcher("login_error.jsp");
                    rd.forward(request, response);
                }
                out.println("<h1>Servlet ControllerServlet at " + request.getContextPath() + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }else if (button.equals("register")){
            String emailcheck = null;
            try{
                Connection connectionUrl = null;           
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://127.0.0.1/studentdb";
                connectionUrl = DriverManager.getConnection(url,"student","dbpassword"); //8084?
                Statement st = connectionUrl.createStatement();
                ResultSet rs = st.executeQuery("select username from users where email ='"+email+"'");
                while (rs.next()){
                    emailcheck = rs.getString("username");
                }
                connectionUrl.close();
                if(emailcheck != null){
                    try (PrintWriter out = response.getWriter()){
                        out.println("<script>alert(\"Email already registered\");</script>");
                        out.println("<meta http-equiv=\"refresh\" content=\"0; url=register.jsp\" />");
                    }
                }else{
                    if(password.equals(confirmpassword)){
                        System.out.println("CHCKCKCK");
                        User nuser = new User(nickname,password,email);
                    }else{
                        try (PrintWriter out = response.getWriter()){
                        out.println("<script>alert(\"Passwords are not the same\");</script>");
                        out.println("<meta http-equiv=\"refresh\" content=\"0; url=register.jsp\" />");
                        }
                    }
                }
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
                
=======
        
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        request.setAttribute("TEST", user);
        
        boolean status = user.validate();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            if (status){
//               out.println("<p>---------------------------success---------------------</p>");
               RequestDispatcher rd = request.getRequestDispatcher("login_success.jsp");
               rd.forward(request, response);
            }
            else{
//                out.println("<p>---------------------------fail---------------------</p>");
                RequestDispatcher rd = request.getRequestDispatcher("login_error.jsp");
                rd.forward(request, response);
>>>>>>> 534c71743fe16eeef46b1fe14360d8afdef306ba
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
        } catch (SQLException ex) {
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "a login controller servlet";
    }// </editor-fold>

}
