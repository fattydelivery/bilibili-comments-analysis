package io.github.fattydelivery.bilibilicommentsanalysis.entity;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-24-16:38
 **/
public class Comment {
    private float appearanceTime;
    private int commentType;
    private int commentSize;
    private int commentColor;
    private int sendTimestamp;
    private String senderUid;
    private Long commentDmId;
    private String commentText;

    public Comment() {
        this.appearanceTime = 0;
        this.commentType = 0;
        this.commentSize = 0;
        this.commentColor = 0;
        this.sendTimestamp = 0;
        this.senderUid = null;
        this.commentDmId = null;
        this.commentText = null;
    }

    public Comment(float appearanceTime, int commentType, int commentSize, int commentColor, int sendTimestamp,
                   String senderUid, Long commentDmId, String commentText) {
        this.appearanceTime = appearanceTime;
        this.commentType = commentType;
        this.commentSize = commentSize;
        this.commentColor = commentColor;
        this.sendTimestamp = sendTimestamp;
        this.senderUid = senderUid;
        this.commentDmId = commentDmId;
        this.commentText = commentText;
    }

    public Comment(String appearanceTime, String commentType, String commentSize, String commentColor, String sendTimestamp,
                   String senderUid, String commentDmId, String commentText) {
        this.appearanceTime = Float.parseFloat(appearanceTime);
        this.commentType = Integer.parseInt(commentType);
        this.commentSize = Integer.parseInt(commentSize);
        this.commentColor = Integer.parseInt(commentColor);
        this.sendTimestamp = Integer.parseInt(sendTimestamp);
        this.senderUid = senderUid;
        this.commentDmId = Long.parseLong(commentDmId);
        this.commentText = commentText;
    }

    public float getAppearanceTime() {
        return appearanceTime;
    }

    public void setAppearanceTime(float appearanceTime) {
        this.appearanceTime = appearanceTime;
    }

    public int getCommentType() {
        return commentType;
    }

    public void setCommentType(int commentType) {
        this.commentType = commentType;
    }

    public int getCommentSize() {
        return commentSize;
    }

    public void setCommentSize(int commentSize) {
        this.commentSize = commentSize;
    }

    public int getCommentColor() {
        return commentColor;
    }

    public void setCommentColor(int commentColor) {
        this.commentColor = commentColor;
    }

    public int getSendTimestamp() {
        return sendTimestamp;
    }

    public void setSendTimestamp(int sendTimestamp) {
        this.sendTimestamp = sendTimestamp;
    }

    public String getSenderUid() {
        return senderUid;
    }

    public void setSenderUid(String senderUid) {
        this.senderUid = senderUid;
    }

    public Long getCommentDmId() {
        return commentDmId;
    }

    public void setCommentDmId(Long commentDmId) {
        this.commentDmId = commentDmId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
