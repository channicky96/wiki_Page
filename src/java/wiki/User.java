package wiki;

import java.util.ArrayList;
import java.sql.*;
//import java.util.Random;

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
    
    public User(String userName,int iD,String nickName, String uPassword, String uEmail, int rating, ArrayList<Article> a) throws SQLException{
        
        Profile newU = new Profile(nickName, uEmail,rating,a);
        
        username = userName;
        id = iD;
        password = uPassword;
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
}