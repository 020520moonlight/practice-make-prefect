package homework.Do;

import homework.Model.Comment;
import homework.Model.User;

import java.time.LocalDateTime;

public class CommentDo {

    private long id;
    private String refId;
    private long userId;
    private long parentId;
    private String content;
    private LocalDateTime gmtCreated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(LocalDateTime gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    private LocalDateTime gmtModified;

    public Comment convertToModel(CommentDo commentDo){
        Comment comment = new Comment();
        comment.setId(commentDo.getId());
        comment.setRefId(commentDo.getRefId());
        User user = new User();
        user.setId(getUserId());
        comment.setAuthor(user);

        comment.setContent(getContent());
        comment.setGmtCreated(getGmtCreated());
        comment.setGmtModified(getGmtCreated());

        return comment;
    }
}
