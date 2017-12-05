package com.coketea.dt.client;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public abstract class AbstractDTClient implements DTClient {

    /**
     * 连接到服务器端的客户端唯一编号
     */
    private String id;

    /**
     * 服务器IP地址
     */
    private String ip = "127.0.0.1";

    /**
     * 服务器端口号
     */
    private int port = 9260;

    public AbstractDTClient() {

    }

    public AbstractDTClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void sendMsg(String msg) throws IOException {
        this.sendMsg(msg.getBytes(StandardCharsets.UTF_8));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
