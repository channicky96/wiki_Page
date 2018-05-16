package wiki;

import java.util.ArrayList;

/**
 *
 * @author btk16xmu
 */
public class Category {

    private int id;
    private String name;
    private ArrayList<String> list;

    public Category() {
        this.name = null;
        list = new ArrayList<>();
    }

    public void clearArticles() {
        getList().clear();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return this.name;
    }
}
