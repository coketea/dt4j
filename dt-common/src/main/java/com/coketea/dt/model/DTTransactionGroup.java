package com.coketea.dt.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class DTTransactionGroup implements Serializable {

    /**
     * 事务组唯一ID
     */
    private String groupId;

    /**
     * 事务参与者唯一ID
     */
    private Set<String> participants;

    /**
     * 向该事务组中添加事务参与者
     * @param participant
     */
    public void addParticipant(String participant) {
        this.participants.add(participant);
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Set<String> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<String> participants) {
        this.participants = participants;
    }
}
