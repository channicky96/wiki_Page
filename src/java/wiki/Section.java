package wiki;

/**
 *
 * @author btk16xmu
 */
public class Section {
    public String title;
    public String content;
    // start new article with a title
    public Section(String title){
        this.title = title;
        content = null;
    }
}
