package com.coketea.dt.client.bio;

import com.coketea.dt.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class BIOSocketClient implements Client {

    final Logger logger = LoggerFactory.getLogger(BIOSocketClient.class);

    /**
     * 服务器IP地址
     */
    private String ip = "127.0.0.1";

    /**
     * 服务器端口号
     */
    private int port = 9260;

    /**
     * 连接至服务器的Socket对象
     */
    private Socket clientSocket;

    /**
     * 发送数据的对象
     */
    private PrintStream out;

    /**
     * 接收数据的对象
     */
    private BufferedReader in;

    public BIOSocketClient() {}

    public BIOSocketClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void connect() throws IOException {
        this.clientSocket = new Socket(this.ip, this.port);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintStream(clientSocket.getOutputStream());
        while (true) {
            out.print("Hello\r\n");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() {
        if (in != null) {
            try {
                in.close();
            } catch (Exception e) {
                logger.error("close BufferedReader object failed", e);
            }
        }

        if (out != null) {
            try {
                out.close();
            } catch (Exception e) {
                logger.error("close PrintStream object failed", e);
            }
        }

        if (this.clientSocket != null) {
            try {
                this.clientSocket.close();
            } catch (Exception e) {
                logger.error("close client socket failed", e);
            }
        }
    }
}
