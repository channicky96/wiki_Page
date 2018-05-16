package wiki;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author btk16xmu
 */
@WebServlet(name = "ArticleServlet", urlPatterns = {"/article/"})
public class ArticleServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        // Session to store a user's informations --------------------------------------------------------------------------------------
        HttpSession session = request.getSession();
        int pageid;
        int userid = 0;
        String searchWord = request.getParameter("keyword");
        String editedAID = request.getParameter("articleID");
        String editorContent = request.getParameter("htmlText");
        String postComment = request.getParameter("comment");
        String category = request.getParameter("category");
        ArrayList<Comment> commentList;
        ArrayList<Article> basket;

        String basketconfirm = request.getParameter("basket");
        String download = request.getParameter("download");
        basket = (ArrayList) session.getAttribute("basket");
        String star = request.getParameter("stars");

        String newsfeed = request.getParameter("newsfeed");
        // show newsfeed
        if (newsfeed != null) {
            if (newsfeed.equals("true")) {
                userid = (Integer) session.getAttribute("userID");

                ArrayList<Newsfeed> feed = showNewsfeed(userid);

                request.setAttribute("bmlist", feed);
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
                return;
            }
        }

        //Check if user already rated
        //rating
        if (star != null) {
            userid = (Integer) session.getAttribute("userID");
            pageid = (Integer) session.getAttribute("pageid");
            switch (star) {
                case "zero":
                    rateAnArticle(userid, pageid, 1);
                    updateAverageRating(pageid);
                    break;
                case "one":
                    rateAnArticle(userid, pageid, 2);
                    updateAverageRating(pageid);
                    break;
                case "two":
                    rateAnArticle(userid, pageid, 3);
                    updateAverageRating(pageid);
                    break;
                case "three":
                    rateAnArticle(userid, pageid, 4);
                    updateAverageRating(pageid);
                    break;
                case "four":
                    rateAnArticle(userid, pageid, 5);
                    updateAverageRating(pageid);
                    break;
                default:
                    break;
            }
            double showRate = showRating(pageid);
            session.setAttribute("newrating", showRate);

        }

        //Basket
        if (basketconfirm != null) {
            boolean added = false;
            pageid = (Integer) session.getAttribute("pageid");

            if (basket != null) {
                for (Article a : basket) {
                    if (a.getId() == pageid) {
                        added = true;
                    }
                }
                if (added == false) {
                    basket.add(getArticle(pageid));
                    session.setAttribute("basket", basket);
                }
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayArticle.jsp");
            dispatcher.forward(request, response);
        }

        // Generate offline readable file
        if (download != null) {
            if (basket != null) {
                String fileAddress = "\\\\ueahome4\\stusci1\\acc16scu\\data\\Documents\\main\\web\\test.txt";
                try {
                    PrintWriter writer = new PrintWriter(new FileOutputStream(fileAddress, false));

                    for (Article a : basket) {
                        String temp = a.toString().replaceAll("<[^>]*>", "");
                        temp = temp.replaceAll("[\\[\\]]", "");
                        System.out.println(temp);
                        writer.write(temp + "\r\n");
                    }
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/basket.jsp");
            dispatcher.forward(request, response);
        }

        // create new article
        if (category != null) {
            String name = request.getParameter("name");
            userid = (Integer) session.getAttribute("userID");
            createArticle(userid, name, category);
            // Set search word and continue
            searchWord = name;
        }
        // edit
        if (editedAID != null) {
            int order = Integer.parseInt(request.getParameter("paraID"));
            String removing = request.getParameter("removeSection");
            // delete a section
            if (removing != null && removing.equals("1")) {
                removeSection(Integer.parseInt(editedAID), order);
            } else {
                try {
                    Connection connectionUrl;
                    Class.forName("org.postgresql.Driver");
                    String url = "jdbc:postgresql://127.0.0.1/studentdb";
                    connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
                    Statement st = connectionUrl.createStatement();
                    String sectionQuery;
                    // create a new section
                    if (order == -1) {
                        int maxOrder = 0;
                        sectionQuery = "SELECT MAX(section_order) FROM sections WHERE article_id="
                                + editedAID + ";";
                        ResultSet rs = st.executeQuery(sectionQuery);
                        while (rs.next()) {
                            maxOrder = rs.getInt(1);
                            break;
                        }
                        String insertSection = "INSERT INTO sections VALUES("
                                + editedAID + "," + (maxOrder + 1) + ",'No title','Please add content');";
                        rs.close();
                        st.executeUpdate(insertSection);
                        order = maxOrder + 1;
                        // empty editor
                        session.setAttribute("content", "");
                        session.setAttribute("title", "");
                    } else {
                        // editing a section
                        sectionQuery = "select title, content from sections where article_id = "
                                + editedAID + " AND section_order = " + order + ";";
                        ResultSet rs = st.executeQuery(sectionQuery);
                        while (rs.next()) {
                            session.setAttribute("content", rs.getString("content"));
                            session.setAttribute("title", rs.getString("title"));
                            break;
                        }
                        rs.close();
                    }
                    ResultSet nameRs = st.executeQuery("select name from articles where id="
                            + editedAID);
                    while (nameRs.next()) {
                        session.setAttribute("aName", nameRs.getString("name"));
                        break;
                    }
                    nameRs.close();

                    session.setAttribute("aID", editedAID);
                    session.setAttribute("sID", order);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("../articleeditor.jsp");
                    dispatcher.forward(request, response);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // Receive editor content ------------------------------------------------------------------------------------------------------
        if (editorContent
                != null) {
            Timestamp time = new Timestamp(System.currentTimeMillis());
            userid = (Integer) session.getAttribute("userID");

            int aID = Integer.parseInt(request.getParameter("editedArticle"));
            int sID = Integer.parseInt(request.getParameter("editedSection"));
            String aName = request.getParameter("editedArticleName");

            String editedTitle = request.getParameter("editedTitle");

            updateSection(aID, sID, editedTitle, editorContent, time, userid);
            //set search word and continue 
            searchWord = aName;
        }

        // Loading the page normally ---------------------------------------------------------------------------------------------------
        if (postComment
                != null) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            userid = (Integer) session.getAttribute("userID");
            pageid = (Integer) session.getAttribute("pageid");

            addComment(pageid, postComment, userid, timestamp);
            commentList = showComments(pageid);
            session.setAttribute("comments", commentList);
            postComment = null;

            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayArticle.jsp");
            dispatcher.forward(request, response);

        } else {
            // If nothing is entered in the search bar
            if (searchWord == null || "".equals(searchWord)) {
                response.sendRedirect("/NoodlesWiki/404.jsp");
                return;
            }
            int chk;
            try {
                // Search for articles --------------------------------------------------------------------------------------------------
                Connection connectionUrl;
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://127.0.0.1/studentdb";
                connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
                Statement st = connectionUrl.createStatement();
                // Case insensitive
                ResultSet articleRs = st.executeQuery("select * from articles where LOWER(name) = LOWER('" + searchWord + "');");
                String dbArticle = null;
                int aId = 0;
                double aRate = 3.0;
                Article result = null;
                Timestamp aTime = null;

                while (articleRs.next()) {
                    dbArticle = articleRs.getString("name");
                    aId = articleRs.getInt("id");
                    aRate = articleRs.getDouble("rate");
                    aTime = articleRs.getTimestamp("last_edit");
                }
                if (dbArticle != null) {
                    Article foundArticle = new Article();
                    foundArticle.setName(dbArticle);
                    foundArticle.setId(aId);
                    foundArticle.setRate(aRate);
                    foundArticle.setLastEditTime(aTime);

                    articleRs.close();
                    ResultSet sectionRs = st.executeQuery("select * from sections where article_id ='" + aId + "' ORDER BY section_order");
                    while (sectionRs.next()) {
                        Section temp = new Section();
                        temp.setOrder(sectionRs.getInt("section_order"));
                        temp.setTitle(sectionRs.getString("title"));
                        temp.setContent(sectionRs.getString("content"));

                        foundArticle.addSection(temp);
                    }
                    result = foundArticle;
                }
                if (result == null) {
                    ArrayList<String> matches = new ArrayList<>();
                    ResultSet similar = st.executeQuery("select * from articles where LOWER(name) LIKE LOWER('" + searchWord + "%');");

                    while (similar.next()) {
                        matches.add(similar.getString("name"));
                    }

                    if (matches.isEmpty()) {
                        response.sendRedirect("/NoodlesWiki/404.jsp");
                        return;
                    } else {
                        request.setAttribute("matchList", matches);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/404.jsp");
                        dispatcher.forward(request, response);
                        return;
                    }
                }
                connectionUrl.close();

                updateAverageRating(aId);
                double showRate = showRating(aId);
                session.setAttribute("newrating", showRate);

                List<Section> sendSections = result.getSections();

                pageid = result.getId();
                String loginchk = (String) session.getAttribute("username");
                session.setAttribute("pageid", pageid);
                session.setAttribute("name", result.getName());
                session.setAttribute("last_edit", result.getLastEditTime());
                session.setAttribute("sections", sendSections);

                if (loginchk != null) {
                    userid = (Integer) session.getAttribute("userID");
                    chk = checkBookmarks(userid, pageid);
                    session.setAttribute("bookmark", chk);

                } else {
                    session.setAttribute("bookmark", 0);
                }

                // Load the comment before the redirect
                commentList = showComments(pageid);
                session.setAttribute("comments", commentList);

                // Change the icon depends on if the user has book marked the article ------------------------------------------------------
                String crm = request.getParameter("bml");
                if (crm != null) {
                    if (crm.equals("rbm")) {
                        removeBookmark(userid, pageid);
                        chk = 0;
                        session.setAttribute("bookmark", chk);
                    } else if (crm.equals("abm")) {
                        addBookmark(userid, pageid);
                        chk = 1;
                        session.setAttribute("bookmark", chk);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/displayArticle.jsp");

        dispatcher.forward(request, response);
    }

// Function to retrieve bookmarked article(s) for a user -------------------------------------------------------------------------------
    public int checkBookmarks(int userid, int articleid) {
        int ans = 0;
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            ResultSet articleRs = st.executeQuery("select articleid from bookmarks where userid ='" + userid + "' and articleid ='" + articleid + "'");
            while (articleRs.next()) {
                if (articleRs.getInt("articleid") == articleid) {
                    ans = 1;
                }
            }
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    // Function to remove a bookmarked article from a user
    public void removeBookmark(int userid, int articleid) {
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            st.executeUpdate("delete from bookmarks where userid ='" + userid + "'and articleid ='" + articleid + "'");
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Function to bookmark an article for a user
    public void addBookmark(int userid, int articleid) {
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            st.executeUpdate("insert into bookmarks (userid, articleid) values ('" + userid + "','" + articleid + "')");
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Function to retrieve comment(s) in the database for an article
    public ArrayList<Comment> showComments(int articleid) {
        ArrayList<Comment> cal = new ArrayList<>();
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            ResultSet commentRs = st.executeQuery("select nickname, comment, commentdt from comments inner join users on comments.userid=users.id where articleid = '" + articleid + "' order by commentdt desc");
            while (commentRs.next()) {
                String nickname = commentRs.getString("nickname");
                String comment = commentRs.getString("comment");
                Timestamp timestamp = commentRs.getTimestamp("commentdt");
                Comment c = new Comment(nickname, comment, timestamp);
                cal.add(c);
            }
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cal;
    }

    // Function to add a comment to an article
    public void addComment(int articleid, String comment, int userid, Timestamp time) {
        int maxid = 0;
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            Statement st1 = connectionUrl.createStatement();
            ResultSet rs = st.executeQuery("select max(id) as maxcid from comments");
            while (rs.next()) {
                maxid = rs.getInt("maxcid") + 1;
            }
            st.executeUpdate("INSERT into comments(id,articleid,userid,commentdt,comment) values ('" + maxid + "','" + articleid + "','" + userid + "','" + time + "','" + comment + "')");
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Function to update a section of an article
    public void updateSection(int articleID, int sectionOrder, String title, String content, Timestamp time, int uID) {
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            Statement st2 = connectionUrl.createStatement();

            String q = "UPDATE sections SET title='" + title + "', content='" + content + "' WHERE article_id="
                    + articleID + " AND section_order=" + sectionOrder + ";";
            st.executeUpdate(q);

            String articleTime = "UPDATE articles SET last_edit='" + time
                    + "', last_editor='" + uID + "' WHERE id='" + articleID + "';";
            st2.executeUpdate(articleTime);
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Article getArticle(int id) {
        Article tempA = new Article();
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            ResultSet artRs = st.executeQuery("select * from articles where id = " + id + ";");
            while (artRs.next()) {
                String name = artRs.getString("name");
                double rate = artRs.getDouble("rate");

                tempA = new Article(id, name, null, null, rate);
            }
            ResultSet secRs = st.executeQuery("select * from sections where article_id = " + id + " order by section_order asc");
            ArrayList<Section> tempS = new ArrayList();
            while (secRs.next()) {
                int order = secRs.getInt("section_order");
                String title = secRs.getString("title");
                String content = secRs.getString("content");
                Section ss = new Section(order, title, content);
                tempS.add(ss);
            }
            tempA.setSections(tempS);

            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempA;
    }

    //rate an article
    public void rateAnArticle(int userid, int articleid, int rate) {
        int user = 0;
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            Statement st1 = connectionUrl.createStatement();
            Statement st2 = connectionUrl.createStatement();
            ResultSet rs = st.executeQuery("select userid from rating where userid= '" + userid + "'and articleid = '" + articleid + "'");
            while (rs.next()) {
                user = rs.getInt("userid");
            }
            if (user != 0 && user == userid) {
                st2.executeUpdate("update rating set rating = '" + rate + "' where userid = '" + userid + "'and articleid = '" + articleid + "'");
            } else {
                st.executeUpdate("insert into rating (userid, articleid, rating) values ('" + userid + "','" + articleid + "','" + rate + "')");
            }
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeSection(int articleID, int sectionOrder) {
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            String q = "DELETE FROM sections WHERE article_id="
                    + articleID + " AND section_order=" + sectionOrder + ";";

            st.executeUpdate(q);
            connectionUrl.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAverageRating(int articleid) {
        double rate = 0;
        int count = 0;
        double mean = 0;
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            Statement st1 = connectionUrl.createStatement();

            ResultSet rs = st.executeQuery("select count(articleid) as count ,sum(rating) as totalrate from rating where articleid = '" + articleid + "'");
            while (rs.next()) {
                count = rs.getInt("count");
                rate = rs.getDouble("totalrate");
                mean = rate / count;
                st1.executeUpdate("update articles set rate = '" + mean + "' where id = '" + articleid + "';");
            }
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double showRating(int articleid) {
        double rating = 0;
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            ResultSet rs = st.executeQuery("select rate from articles where id = '" + articleid + "'");
            while (rs.next()) {
                rating = rs.getDouble("rate");
            }
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rating;
    }

    public void createArticle(int userid, String name, String category) {
        int maxid = 0;
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            Statement st1 = connectionUrl.createStatement();
            ResultSet rs = st1.executeQuery("select max(id) as maxid from articles");
            while (rs.next()) {
                maxid = rs.getInt("maxid") + 1;
            }
            st.executeUpdate("insert into articles (id, name, rate, category, creator, last_editor)"
                    + " values ('" + maxid + "','" + name + "', 0, '" + category + "','" + userid + "','" + userid + "')");
            connectionUrl.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Newsfeed> showNewsfeed(int userid) {
        ArrayList<Newsfeed> newsfeed = new ArrayList<>();
        Newsfeed temp;
        String sub;

        String query = "select last_edit, name, content from\n"
                + "(select * from(\n"
                + "select articles.last_edit,articles.name,articles.id from articles \n"
                + "right join bookmarks on articles.id=bookmarks.articleid\n"
                + "where bookmarks.userid=" + userid
                + ")t0\n"
                + "inner join\n"
                + "(\n"
                + "select min(section_order) as first_para,article_id from sections\n"
                + "group by article_id\n"
                + ")t1\n"
                + "on t0.id = t1.article_id) n\n"
                + "inner join sections on n.first_para=sections.section_order and n.article_id = sections.article_id "
                + "order by last_edit desc;";
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            ResultSet nf = st.executeQuery(query);
            while (nf.next()) {
                temp = new Newsfeed();
                temp.setTitle(nf.getString("name"));
                sub = nf.getString("content");
                // preview length limit
                if (sub.length() > 200) {
                    sub = sub.substring(0, 200);
                }
                temp.setPreview(sub);
                temp.setTimestamp(nf.getTimestamp("last_edit"));
                newsfeed.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsfeed;
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
            Logger.getLogger(ArticleServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ArticleServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
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
