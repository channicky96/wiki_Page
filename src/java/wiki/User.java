package wiki;

import java.util.ArrayList;
import java.sql.*;
import java.util.Random;

/**
 *
 * @author btk16xmu
 */
public class User {
    private String username;
    private int id;
    private String password;
    private ArrayList<Article> favourite;
    private ArrayList<Article> basket;
    private ArrayList<Newsfeed> feed;
    
    public User(){
        
    }
    
     public User(String nickName, String uPassword, String uEmail) throws SQLException{
        //Profile newU = new Profile(name, email);
        int idd = 0;
        
        Profile pro = new Profile(nickName, uEmail);
        
        try{
                Connection connectionUrl;             
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://127.0.0.1/studentdb";
                connectionUrl = DriverManager.getConnection(url,"student","dbpassword"); //8084?
                Statement st = connectionUrl.createStatement();
                ResultSet rs = st.executeQuery("select max(id) as maxid from users");
                while (rs.next()){
                    idd = rs.getInt("maxid")+1;
                    System.out.println("mkmkmkmkduidwu");
                    System.out.println(idd);
                }
                connectionUrl.close();
                
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
                
            }
        Random rand = new Random();
        String tempusername = nickName+rand.nextInt(99999);
        while(checkUsername(tempusername) == false){
            tempusername = nickName+rand.nextInt(99999);
        }
        username = tempusername;
        id = idd;
        password = uPassword;
        
        try{
                Connection connectionUrl;           
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://127.0.0.1/studentdb";
                connectionUrl = DriverManager.getConnection(url,"student","dbpassword"); //8084?
                Statement st = connectionUrl.createStatement();
                ResultSet rs = st.executeQuery("insert into users(id,username,userpassword,email,nickname) values('"+id+"','"+username+"','"+password+"','"+uEmail+"','"+nickName+"')");
                while (rs.next()){
                    
                }
                connectionUrl.close();
                
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
                
            }
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the favourite
     */
    public ArrayList<Article> getFavourite() {
        return favourite;
    }

    /**
     * @param favourite the favourite to set
     */
    public void setFavourite(ArrayList<Article> favourite) {
        this.favourite = favourite;
    }

    /**
     * @return the basket
     */
    public ArrayList<Article> getBasket() {
        return basket;
    }

    /**
     * @param basket the basket to set
     */
    public void setBasket(ArrayList<Article> basket) {
        this.basket = basket;
    }

    /**
     * @return the feed
     */
    public ArrayList<Newsfeed> getFeed() {
        return feed;
    }

    /**
     * @param feed the feed to set
     */
    public void setFeed(ArrayList<Newsfeed> feed) {
        this.feed = feed;
    }
    
    public boolean validate(String username) throws SQLException{
        try{
                Connection connectionUrl = null;
//                session.putValue("userid",userid);
//                String pwd = request.getParameter("userpassword");             
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://127.0.0.1/studentdb";
                connectionUrl = DriverManager.getConnection(url,"student","dbpassword"); //8084?
                Statement st = connectionUrl.createStatement();
                ResultSet rs = st.executeQuery("select userpassword from users where username ='"+username+"'");
                while (rs.next()){
                    String passw = rs.getString("userpassword");
                    return password.equals(passw);
                }
                connectionUrl.close();
                
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
                
            }
        return false;
    }
    
    public boolean checkUsername(String tUsername) throws SQLException{
        String tun = null;
        try{
                Connection connectionUrl;           
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://127.0.0.1/studentdb";
                connectionUrl = DriverManager.getConnection(url,"student","dbpassword"); //8084?
                Statement st = connectionUrl.createStatement();
                ResultSet rs = st.executeQuery("select username from users where username ='"+tUsername+"'");
                while (rs.next()){
                    tun = rs.getString("username");
                }
                connectionUrl.close();
                if(tun == null){
                    return true;
                }
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
                
            }
        return false;
    }
}
