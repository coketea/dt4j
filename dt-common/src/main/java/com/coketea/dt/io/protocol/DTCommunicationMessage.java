package com.coketea.dt.io.protocol;

import java.util.UUID;

public class DTCommunicationMessage {

    /**
     * 操作类型
     * @see Actions
     */
    private String action;

    /**
     * 附加的数据
     */
    private String attachedData;

    /**
     * 消息唯一编号
     */
    private String uuid;

    /**
     * 答复的消息编号
     */
    private String replyUuid;

    public DTCommunicationMessage() {
        this.uuid = UUID.randomUUID().toString();
    }

    public DTCommunicationMessage(String action, String attachedData, String replyUuid) {
        this();
        this.action = action;
        this.attachedData = attachedData;
        this.replyUuid = replyUuid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAttachedData() {
        return attachedData;
    }

    public void setAttachedData(String attachedData) {
        this.attachedData = attachedData;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getReplyUuid() {
        return replyUuid;
    }

    public void setReplyUuid(String replyUuid) {
        this.replyUuid = replyUuid;
    }
}
