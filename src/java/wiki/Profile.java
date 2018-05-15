package wiki;

import java.util.ArrayList;

/**
 *
 * @author btk16xmu
 */
public class Profile {

    private String name;
    private String email;
    private ArrayList<Article> contributed;
    private int rate;    // like:+1, dislike:-1

    public Profile() {
        name = null;
        email = null;
        contributed = new ArrayList<>();
        rate = 0;
    }

    public Profile(String name, String email, int rate, ArrayList<Article> contributed) {
        this.name = name;
        this.email = email;
        this.contributed = contributed;
        this.rate = rate;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the contributed
     */
    public ArrayList<Article> getContributed() {
        return contributed;
    }

    /**
     * @param contributed the contributed to set
     */
    public void setContributed(ArrayList<Article> contributed) {
        this.contributed = contributed;
    }

    /**
     * @return the rate
     */
    public int getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(int rate) {
        this.rate = rate;
    }

    public void rateup() {
        this.rate++;
    }

    public void ratedown() {
        this.rate--;
    }

    @Override
    public String toString() {
        StringBuilder contributes = new StringBuilder();
        for (Article a : contributed) {
            contributes.append(a.toString());
        }
        return contributes.toString();
    }
}
