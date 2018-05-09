package wiki;

import java.sql.Timestamp;

/**
 *
 * @author btk16xmu
 */
public class Comment {
    private String username;
    private String comment;
    private Timestamp timestamp;
    
    public Comment(){
        
    }
    
    public Comment(String cUser,String cComment,Timestamp cTime){
        username = cUser;
        comment = cComment;
        timestamp = cTime;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
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
