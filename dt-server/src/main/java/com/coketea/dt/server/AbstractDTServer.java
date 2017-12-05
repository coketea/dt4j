package com.coketea.dt.server;

public abstract class AbstractDTServer implements DTServer {

    /**
     * 标识服务器是否正在运行，当关闭应用时应该将其置为false，以便服务器正常关闭
     */
    private boolean running = true;

    /**
     * 服务器监听的端口号
     */
    private int port = 9260;

    public AbstractDTServer() {

    };

    public AbstractDTServer(int port) {
        this.port = port;
    }

    @Override
    public void shutdown() {
        this.running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
