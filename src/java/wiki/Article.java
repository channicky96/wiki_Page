package wiki;

import java.util.ArrayList;

/**
 *
 * @author btk16xmu
 */
public class Article {
    private int id;
    private String name;
    private ArrayList<String> tags;
    private double rate;
    
    public Article(int aID, String aName, ArrayList<String> aTag, double aRating){
        this.id = aID;
        this.name = aName;
        this.tags = aTag;
        this.rate = aRating;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the tags
     */
    public ArrayList<String> getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    /**
     * @return the rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(double rate) {
        this.rate = rate;
    }
    
    
}
