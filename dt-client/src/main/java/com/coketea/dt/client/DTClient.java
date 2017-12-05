package com.coketea.dt.client;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface DTClient {

    /**
     * 与服务器建立连接
     */
    void connect() throws Exception;

    /**
     * 与服务器断开连接
     */
    void close();

    /**
     * 向服务器端发送消息
     * @param msg 字节格式的消息内容
     */
    void sendMsg(byte[] msg) throws IOException;

    /**
     * 向服务器端发送消息<br/>
     * <b>注意：</b>所有的字符串在传输过程中均转成UTF-8编码的字节流
     * @param msg 字符串消息内容
     */
    void sendMsg(String msg) throws IOException;

    /**
     * 从服务器端接收字符串格式的消息<br/>
     * <b>注意：</b>接收到的字符串均以UTF-8编码
     * @return 消息内容
     * @throws IOException
     */
    String receiveMsg() throws IOException;
}
