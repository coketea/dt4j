package com.coketea.dt.server.bio;

import com.alibaba.fastjson.JSONObject;
import com.coketea.dt.io.protocol.Actions;
import com.coketea.dt.io.protocol.DTCommunicationMessage;
import com.coketea.dt.io.protocol.MessageHandler;

import java.util.UUID;

public class BIORequestMessageHandler implements MessageHandler {

    BIORequestHandler requestHandler = null;

    public BIORequestMessageHandler(BIORequestHandler bioRequestHandler) {
        this.requestHandler = bioRequestHandler;
    }

    @Override
    public DTCommunicationMessage handle(String msg) {
        DTCommunicationMessage msgReceived = JSONObject.parseObject(msg, DTCommunicationMessage.class);
        DTCommunicationMessage msgSend = new DTCommunicationMessage();

        //注册事件
        if (Actions.REGISTER.equals(msgReceived.getAction())) {
            msgSend.setReplyUuid(msgReceived.getUuid());
            msgSend.setAction(Actions.ACK_SUCCESS);
            msgSend.setAttachedData(UUID.randomUUID().toString());
            this.requestHandler.addSelfToClientList(msgSend.getAttachedData());
        }

        return msgSend;
    }
}
