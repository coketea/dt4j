package com.coketea.dt.server;

import java.io.IOException;

public interface RequestHandler {

    /**
     * 将自己添加到服务器端处理列表中
     * @param clientId 客户端唯一编号
     */
    void addSelfToClientList(String clientId);

    /**
     * 向客户端发送消息
     * @param msg 字节格式的消息内容
     */
    void sendMsg(byte[] msg) throws IOException;

    /**
     * 向客户端发送消息<br/>
     * <b>注意：</b>所有的字符串在传输过程中均转成UTF-8编码的字节流
     * @param msg 字符串消息内容
     */
    void sendMsg(String msg) throws IOException;
}
