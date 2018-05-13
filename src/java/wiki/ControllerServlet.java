package wiki;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/ControllerServlet"})
public class ControllerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        // Login requirements ----------------------------------------------------------------------------------------------------------
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");
        String confirmpassword = request.getParameter("password1");
        String email = request.getParameter("useremail");
        String button = request.getParameter("button");

        // Database connection data ----------------------------------------------------------------------------------------------------
        String dbUsername = "student";
        String dbpassword = "dbpassword";

        // Prepared query statements ---------------------------------------------------------------------------------------------------
        String query = "select * from users where username ='" + username + "'";
        String query2 = "select username from users where email ='" + email + "'";
        String query3 = "select max(id) as maxid from users";

        // Session to store a user's informations --------------------------------------------------------------------------------------
        HttpSession session = request.getSession();

        // Logout ----------------------------------------------------------------------------------------------------------------------    
        if (button.equals("Logout")) {
            session.invalidate();
            String redirectURL = "index.jsp";
            response.sendRedirect(redirectURL);
        }

        // Login -----------------------------------------------------------------------------------------------------------------------    
        if (button.equals("Login")) { //IF USER IS LOGGING IN

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            request.setAttribute("TEST", user);
            boolean status = validate(username, password);
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ControllerServlet</title>");
                out.println("</head>");
                out.println("<body>");
                if (status) {
                    int idA = 0;
                    String emailB = null;
                    String nicknameC = null;
                    String passwordD = null;
                    session.setAttribute("username", username);
                    try {
                        // Connect to postgreSQL to get the desired data
                        Connection connectionUrlA = null;
                        Class.forName("org.postgresql.Driver");
                        String urlA = "jdbc:postgresql://127.0.0.1/studentdb";
                        connectionUrlA = DriverManager.getConnection(urlA, dbUsername, dbpassword);
                        Statement stA = connectionUrlA.createStatement();
                        ResultSet rsA = stA.executeQuery(query);
                        while (rsA.next()) {
                            idA = rsA.getInt("id");
                            emailB = rsA.getString("email");
                            nicknameC = rsA.getString("nickname");
                            passwordD = rsA.getString("userpassword");
                        }
                        connectionUrlA.close();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    ArrayList<Article> basket = new ArrayList<>();
                    session.setAttribute("userID", idA);
                    session.setAttribute("userEmail", emailB);
                    session.setAttribute("userNickname", nicknameC);
                    session.setAttribute("userpassword", passwordD);
                    session.setAttribute("basket", basket);
                    // Redirects to pages
                    RequestDispatcher rd = request.getRequestDispatcher("login_success.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("login_error.jsp");
                    rd.forward(request, response);
                }
            }
        } // Register a new user --------------------------------------------------------------------------------------------------------
        else if (button.equals("Register")) {
            String emailcheck = null;
            try {
                // Connect to postgreSQL to get the desired data
                Connection connectionUrl = null;
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://127.0.0.1/studentdb";
                connectionUrl = DriverManager.getConnection(url, dbUsername, dbpassword);
                Statement st = connectionUrl.createStatement();
                ResultSet rs = st.executeQuery(query2);

                while (rs.next()) {
                    emailcheck = rs.getString("username");
                }
                connectionUrl.close();
                // If email is already used to register
                if (emailcheck != null) {
                    try (PrintWriter out = response.getWriter()) {
                        out.println("<script>alert(\"Email already registered\");</script>");
                        out.println("<meta http-equiv=\"refresh\" content=\"0; url=register.jsp\" />");
                    }
                } else if (password.equals(confirmpassword)) {
                    int id = 0;
                    try {
                        Connection connectionUrl1;
                        Class.forName("org.postgresql.Driver");
                        String url1 = "jdbc:postgresql://127.0.0.1/studentdb";
                        connectionUrl1 = DriverManager.getConnection(url1, dbUsername, dbpassword);
                        Statement st1 = connectionUrl1.createStatement();
                        ResultSet rs1 = st1.executeQuery(query3);
                        while (rs1.next()) {
                            id = rs1.getInt("maxid") + 1;
                        }
                        connectionUrl1.close();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    // Generate a username for a user for them to log in
                    Random rand = new Random();
                    String newusername = nickname + rand.nextInt(99999);
                    while (checkUsername(newusername) == false) {
                        newusername = nickname + rand.nextInt(99999);
                    }
                    String query4 = "insert into users(id,username,userpassword,email,nickname) values('" + id + "','" + newusername + "','" + password + "','" + email + "','" + nickname + "')";
                    try {
                        // Insert a user's detail to register them
                        Connection connectionUrl2;
                        Class.forName("org.postgresql.Driver");
                        String url2 = "jdbc:postgresql://127.0.0.1/studentdb";

                        connectionUrl2 = DriverManager.getConnection(url2, dbUsername, dbpassword);

                        Statement st2 = connectionUrl2.createStatement();
                        st2.executeUpdate(query4);
                        connectionUrl2.close();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    // Create a new User object
                    User nuser = new User(newusername, id, nickname, password, email);
                    session.setAttribute("username", newusername);
                    session.setAttribute("userID", id);
                    session.setAttribute("userEmail", email);
                    session.setAttribute("userNickname", nickname);
                    session.setAttribute("userpassword", password);
                } else {
                    // If password and comfrmed password is not identical, alert is displayed
                    try (PrintWriter out = response.getWriter()) {
                        out.println("<script>alert(\"Passwords are not the same\");</script>");
                        out.println("<meta http-equiv=\"refresh\" content=\"0; url=register.jsp\" />");
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            RequestDispatcher rd = request.getRequestDispatcher("userdetail.jsp");
            rd.forward(request, response);
        } // Change password -------------------------------------------------------------------------------------------------------------     
        else if (button.equals("Change Password")) {
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");
            String confirmPassword = request.getParameter("confirmNewPassword");
            String getUsername = (String) session.getAttribute("username");
            String queryA = ("UPDATE users SET userpassword = '" + newPassword + "' WHERE username = '" + getUsername + "'");
            String queryB = ("SELECT userpassword FROM users WHERE username = '" + getUsername + "'");
            try {
                Connection connectionUrl5;
                Class.forName("org.postgresql.Driver");
                String url5 = "jdbc:postgresql://127.0.0.1/studentdb";
                connectionUrl5 = DriverManager.getConnection(url5, dbUsername, dbpassword);
                Statement st5 = connectionUrl5.createStatement();
                Statement st6 = connectionUrl5.createStatement();
                ResultSet rs6 = st6.executeQuery(queryB);
                while (rs6.next()) {
                    if ((rs6.getString("userpassword")).equals(oldPassword) && newPassword.equals(confirmPassword)) {
                        try (PrintWriter out = response.getWriter()) {
                            out.print("<script>alert(\"Password changed!\");</script>");
                            out.println("<meta http-equiv=\"refresh\" content=\"0; url=userdetail.jsp\" />");
                        }
                        String redirectToUserDetail = "userdetail.jsp";
                        response.sendRedirect(redirectToUserDetail);
                        st5.executeUpdate(queryA);
                    } else {
                        try (PrintWriter out = response.getWriter()) {
                            out.print("<script>alert(\"Passwords are not the same\");</script>");
                            out.println("<meta http-equiv=\"refresh\" content=\"0; url=userdetail.jsp\" />");
                        }
                    }
                }
                connectionUrl5.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } // Change Nickname -------------------------------------------------------------------------------------------------------------   
        else if (button.equals("Change Nickname")) {
            String getNickname = request.getParameter("newNickname");
            String getUsername = (String) session.getAttribute("username");
            String queryC = ("UPDATE users SET nickname = '" + getNickname + "' WHERE username ='" + getUsername + "'");
//            Pattern p = Pattern.compile("[\\p{Punct}]");
            Pattern p = Pattern.compile("^[a-zA-Z0-9 ]*$");

            Matcher m = p.matcher(getNickname);
            if (m.find()) {
                try {
                    Connection connectionUrl7;
                    Class.forName("org.postgresql.Driver");
                    String url7 = "jdbc:postgresql://127.0.0.1/studentdb";
                    connectionUrl7 = DriverManager.getConnection(url7, dbUsername, dbpassword);
                    Statement st7 = connectionUrl7.createStatement();
                    st7.executeUpdate(queryC);
                    session.setAttribute("userNickname", getNickname);
                    String redirectToUserDetail1 = "userdetail.jsp";
                    response.sendRedirect(redirectToUserDetail1);
                    connectionUrl7.close();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                try (PrintWriter out = response.getWriter()) {
                    out.print("<script>alert(\"Please only use alphanumeric characters in your Nickname.\");</script>");
                    out.println("<meta http-equiv=\"refresh\" content=\"0; url=userdetail.jsp\" />");
                }
            }
        }
    }

    // Check for existing username -------------------------------------------------------------------------------------------------------
    public boolean checkUsername(String tUsername) throws SQLException {
        String tun = null;
        String dbUsername = "student";
        String dbpassword = "dbpassword";
        String query = "select username from users where username ='" + tUsername + "'";
        try {
            Connection connectionUrl3;
            Class.forName("org.postgresql.Driver");
            String url3 = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl3 = DriverManager.getConnection(url3, dbUsername, dbpassword);
            Statement st3 = connectionUrl3.createStatement();
            ResultSet rs3 = st3.executeQuery(query);

            while (rs3.next()) {
                tun = rs3.getString("username");
            }
            connectionUrl3.close();
            if (tun == null) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Validate login ----------------------------------------------------------------------------------------------------
    public boolean validate(String username, String password) throws SQLException {
        String dbUsername = "student";
        String dbpassword = "dbpassword";
        String query = "select userpassword from users where username ='" + username + "'";
        try {
            Connection connectionUrl4;
            Class.forName("org.postgresql.Driver");
            String url4 = "jdbc:postgresql://127.0.0.1/studentdb";

            connectionUrl4 = DriverManager.getConnection(url4, dbUsername, dbpassword);

            Statement st4 = connectionUrl4.createStatement();
            ResultSet rs4 = st4.executeQuery(query);
            while (rs4.next()) {
                String passw = rs4.getString("userpassword");
                return password.equals(passw);
            }
            connectionUrl4.close();

        } catch (Exception e) {
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
        return "controller servlet";
    }// </editor-fold>

}
