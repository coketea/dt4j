package com.coketea.dt.server.bio;

import com.coketea.dt.server.AbstractServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BIOSocketServer extends AbstractServer {

    final Logger logger = LoggerFactory.getLogger(BIOSocketServer.class);

    /**
     * 服务器Socket对象
     */
    private ServerSocket serverSocket;

    /**
     * 客户端连接线程池
     */
    private ThreadPoolExecutor clientThreadPool;

    /**
     * 客户端连接线程池大小
     */
    private int clientThreadPoolSize = 100;

    public BIOSocketServer() {
    }

    public BIOSocketServer(int port, int clientThreadPoolSize) {
        super(port);
        this.clientThreadPoolSize = clientThreadPoolSize;
    }

    public void startup() throws IOException {
        logger.info("begin to startup BIOSocketServer");

        this.clientThreadPool = new ThreadPoolExecutor(
                this.clientThreadPoolSize,
                this.clientThreadPoolSize,
                0L,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingDeque<Runnable>()
        );

        logger.info("clientThreadPool created");

        Socket clientSocket = null;
        this.serverSocket = new ServerSocket(this.getPort());
        while (this.isRunning()) {
            clientSocket = this.serverSocket.accept();

            logger.info("new client connected");
            this.clientThreadPool.execute(new BIORequestHandler(this, clientSocket));
        }
        this.clientThreadPool.shutdown();
        logger.info("BIOSocketServer stopped");
    }

    @Override
    public void shutdown() {
        super.shutdown();
        if (this.serverSocket != null) {
            try {
                this.serverSocket.close();
            } catch (Exception e) {
                logger.error("close server socket failed", e);
            }
        }
    }

}
