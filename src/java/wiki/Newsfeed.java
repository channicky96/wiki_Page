package wiki;

import java.sql.Timestamp;

public class Newsfeed {
    private String title;
    private String preview;
    private Timestamp timestamp;

    public Newsfeed(){
        title = null;
        preview = null;
        timestamp = null;
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
     * @return the preview
     */
    public String getPreview() {
        return preview;
    }

    /**
     * @param preview the preview to set
     */
    public void setPreview(String preview) {
        this.preview = preview;
    }

    /**
     * @return the timestamp
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
