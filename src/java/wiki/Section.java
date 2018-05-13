package wiki;

import java.util.Arrays;

/**
 *
 * @author btk16xmu
 */
public class Section {

    private int order;
    private String title;
    private String content;

    public Section() {
        title = null;
        content = null;
    }

    public Section(int ord, String title, String cont) {
        this.order = ord;
        this.title = title;
        this.content = cont;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the order
     */
    public int getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        StringBuilder sectionContent = new StringBuilder();
        sectionContent.append("\n\n").append(title).append("\n").append(content);
        return sectionContent.toString();
    }
}
