package wiki;

import java.sql.Timestamp;
import java.util.ArrayList;


/**
 *
 * @author btk16xmu
 */
public class Article {
    private int id;
    private String name;
    private ArrayList<String> tags;
    private ArrayList<Section> sections;
    private double rate;
    private Timestamp lastEditTime;
    
    public Article(){
        name = null;
        sections = new ArrayList<>();
    }
    
    public Article(int id, String name, ArrayList<String> tag, ArrayList<Section> section, double rate){
        this.id = id;
        this.name = name;
        this.tags = tag;
        this.sections = section;
        this.rate = rate;
    }
    
    public void addSection(Section se){
        sections.add(se);
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

    /**
     * @return the sections
     */
    public ArrayList<Section> getSections() {
        return sections;
    }

    /**
     * @param sections the sections to set
     */
    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }
    
    @Override
    public String toString(){
        StringBuilder articleContent = new StringBuilder();
        articleContent.append("Article Title: \r\n").append(name).append("\r\n").append(sections.toString()).append("\r\n");
        return articleContent.toString();
    }

    /**
     * @return the lastEditTime
     */
    public Timestamp getLastEditTime() {
        return lastEditTime;
    }

    /**
     * @param lastEditTime the lastEditTime to set
     */
    public void setLastEditTime(Timestamp lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
