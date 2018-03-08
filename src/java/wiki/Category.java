package wiki;

import java.util.ArrayList;

/**
 *
 * @author btk16xmu
 */
public class Category {
    private String name;
    private ArrayList<Article> list; // list of articles under this category

    public Category() {
        list = new ArrayList<>();
        //debug
        list.add(new Article("OY"));
    }

    public boolean addArticle(Article a) {
        if (a != null && !list.contains(a)) {
            list.add(a);
            return true;
        }
        return false;
    }
    public boolean clearArticles(){
        list.clear();
        return true;
    }

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
     *
     * @return list of article objects
     */
    public ArrayList<Article> getList() {
        return list;
    }
}
