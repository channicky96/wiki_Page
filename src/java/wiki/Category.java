package wiki;

import java.util.ArrayList;

/**
 *
 * @author btk16xmu
 */
public class Category {
    private int id;
    private String name;
//    private ArrayList<Article> list; // list of articles under this category
    private ArrayList<String> list;

    public Category() {
        this.name = null;
        list = new ArrayList<>();
    }

//    public boolean addArticle(Article a) {
//        if (a != null && !list.contains(a)) {
//            list.add(a);
//            return true;
//        }
//        return false;
//    }
    public void clearArticles(){
        getList().clear();
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

//    public ArrayList<Article> getList() {
//        return list;
//    }

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
    
    @Override
    public String toString(){
        return this.name;
    }

    /**
     * @return the list
     */
    public ArrayList<String> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<String> list) {
        this.list = list;
    }
}
