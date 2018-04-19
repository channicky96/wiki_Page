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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

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
        String nickname = request.getParameter("nickname");
        String confirmpassword = request.getParameter("password1");
        String email = request.getParameter("useremail");
        String button = request.getParameter("button");
        if (button.equals("login")) { //IF USER IS LOGGING IN
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            request.setAttribute("TEST", user);

            boolean status = validate(username, password);

            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ControllerServlet</title>");
                out.println("</head>");
                out.println("<body>");
                if (status) {
                    //out.println("<script>alert(\"Hello\\nSUCESS\");</script>");
                    RequestDispatcher rd = request.getRequestDispatcher("login_success.jsp");
                    rd.forward(request, response);
                } else {
                    //out.println("<script>alert(\"Hello\\nFAIL\");</script>");
                    RequestDispatcher rd = request.getRequestDispatcher("login_error.jsp");
                    rd.forward(request, response);
                }
                out.println("<h1>Servlet ControllerServlet at " + request.getContextPath() + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        } else if (button.equals("register")) { //IF THE USER IS REGISTERING
            String emailcheck = null;
            //-------------------------------------SEE IF EMAIL
            try {
                Connection connectionUrl = null;
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://127.0.0.1/studentdb";
                connectionUrl = DriverManager.getConnection(url, "student", "dbpassword"); //8084?
                Statement st = connectionUrl.createStatement();
                ResultSet rs = st.executeQuery("select username from users where email ='" + email + "'");
                while (rs.next()) {
                    emailcheck = rs.getString("username");
                }
                connectionUrl.close();
                if (emailcheck != null) {
                    try (PrintWriter out = response.getWriter()) {
                        out.println("<script>alert(\"Email already registered\");</script>");
                        out.println("<meta http-equiv=\"refresh\" content=\"0; url=register.jsp\" />");
                    }
                } else if (password.equals(confirmpassword)) {

                    //-------------------------------------CREATE NEW ID
                    int id = 0;

                    try {             
                        Connection connectionUrl1;
                        Class.forName("org.postgresql.Driver");
                        String url1 = "jdbc:postgresql://127.0.0.1/studentdb";
                        connectionUrl1 = DriverManager.getConnection(url1, "student", "dbpassword");
                        Statement st1 = connectionUrl1.createStatement();
                        ResultSet rs1 = st1.executeQuery("select max(id) as maxid from users");
                        while (rs1.next()) {
                            id = rs1.getInt("maxid") + 1;
                            //System.out.println("mkmkmkmkduidwu");
                            System.out.println(id);
                        }
                        connectionUrl1.close();

                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    //---------------------------------------- CHECK FOR EXISTING NICKNAMES
                    Random rand = new Random();
                    String newusername = nickname + rand.nextInt(99999);
                    while (checkUsername(newusername) == false) {
                        newusername = nickname + rand.nextInt(99999);
                    }
                    //---------------------------------------- ADD NEW USER TO DATABASE
                    try {
                        Connection connectionUrl2;           
                        Class.forName("org.postgresql.Driver");
                        String url2 = "jdbc:postgresql://127.0.0.1/studentdb";
                        connectionUrl2 = DriverManager.getConnection(url2, "student", "dbpassword"); //8084?
                        Statement st2 = connectionUrl2.createStatement();
                        System.out.println("HEL MDKOWNDOINW");
                        ResultSet rs2 = st2.executeQuery("insert into users(id,username,userpassword,email,nickname) values('" + id + "','" + newusername + "','" + password + "','" + email + "','" + nickname + "')");
                        while (rs2.next()){
                            
                        }
                        connectionUrl2.close();

                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    //---------------------------------------- 
                    User nuser = new User(newusername, id, nickname, password, email);
                } else {
                    try (PrintWriter out = response.getWriter()) {
                        out.println("<script>alert(\"Passwords are not the same\");</script>");
                        out.println("<meta http-equiv=\"refresh\" content=\"0; url=register.jsp\" />");
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            }
        }
    }

    public boolean checkUsername(String tUsername) throws SQLException { //CHECK FOR EXISTING NICKNAMES
        String tun = null;
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword"); //8084?
            Statement st = connectionUrl.createStatement();
            ResultSet rs = st.executeQuery("select username from users where username ='" + tUsername + "'");
            while (rs.next()) {
                tun = rs.getString("username");
            }
            connectionUrl.close();
            if (tun == null) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        return false;
    }

    public boolean validate(String username, String password) throws SQLException { //VALIDATE LOGIN 
        try {
            Connection connectionUrl = null;
            //                session.putValue("userid",userid);
            //                String pwd = request.getParameter("userpassword");             
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword"); //8084?
            Statement st = connectionUrl.createStatement();
            ResultSet rs = st.executeQuery("select userpassword from users where username ='" + username + "'");
            while (rs.next()) {
                String passw = rs.getString("userpassword");
                return password.equals(passw);
            }
            connectionUrl.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        return false;
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
        return "Short description";
    }// </editor-fold>

}
