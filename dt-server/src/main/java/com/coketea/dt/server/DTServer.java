package com.coketea.dt.server;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface DTServer {

    /**
     * 启动服务器
     */
    void startup() throws Exception;

    /**
     * 停止服务器
     */
    void shutdown();

    /**
     * 标识服务器是否正在运行
     * @return true-正在运行，false-正在停止中
     */
    boolean isRunning();

    /**
     * 将客户端请求处理器添加到服务器管理清单中
     */
    void addClient(String clientId, RequestHandler requestHandler);
}
