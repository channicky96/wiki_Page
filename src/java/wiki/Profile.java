package wiki;

import java.util.ArrayList;

/**
 *
 * @author btk16xmu
 */
public class Profile {
    public String name;
    public String email;
    public ArrayList<Article> contributed;
    public int rate;    // like:+1, dislike:-1
    public Profile(String name, String email){
        this.name = name;
        this.email = email;
        contributed = new ArrayList<>();
        rate = 0;
    }
}
