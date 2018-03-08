package wiki;

import java.util.ArrayList;

/**
 *
 * @author btk16xmu
 */
public class Article {
    private int id;
    public String name;
    public ArrayList<String> tags;
    public double rate;
    public Section sections;
    
    public Article(String title){
        // test constructor
        this.name = title;
        sections = new Section();
    }
    
    @Override
    public String toString(){
        // test
        return name;
    }
    
}
