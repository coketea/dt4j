package com.coketea.dt.server.bio;

import com.coketea.dt.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class BIORequestHandler implements Runnable {

    final Logger logger = LoggerFactory.getLogger(BIORequestHandler.class);

    /**
     * 客户端请求socket对象
     */
    private Socket clientSocket = null;

    /**
     * 持有一个Server对象的引用
     */
    private Server server;

    public BIORequestHandler(Server server, Socket clientSocket) {
        this.server = server;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        PrintStream out = null;
        BufferedReader in = null;
        String msg = null;
        try {
            out = new PrintStream(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while (this.server.isRunning()) {
                msg = in.readLine();
                if (msg == null || msg.length() == 0) {
                    break;
                } else {
                    logger.debug(msg);
                }
            }
        } catch (Exception e) {
            logger.error("request handler execute error", e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    logger.error("close PrintStream object failed", e);
                }
            }

            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    logger.error("close BufferedReader object failed", e);
                }
            }

            if (this.clientSocket != null) {
                try {
                    this.clientSocket.close();
                } catch (Exception e) {
                    logger.error("close clientSocket failed", e);
                }
            }
        }
    }
}
