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
        this.name = null;
        list = new ArrayList<>();
    }

    public boolean addArticle(Article a) {
        if (a != null && !list.contains(a)) {
            list.add(a);
            return true;
        }
        return false;
    }
    public void clearArticles(){
        list.clear();
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public ArrayList<Article> getList() {
        return list;
    }
}
