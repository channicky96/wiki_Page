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
    private ArrayList<Section> sections;
    private double rate;
    
    public Article(){
        name = null;
        sections = new ArrayList<>();
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
    
    
}
