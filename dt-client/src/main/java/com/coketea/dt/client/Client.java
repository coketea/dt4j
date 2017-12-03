package com.coketea.dt.client;

public interface Client {

    /**
     * 与服务器建立连接
     */
    void connect() throws Exception;

    /**
     * 与服务器断开连接
     */
    void close();
}
