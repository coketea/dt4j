package com.coketea.dt.client.bio;

import com.coketea.dt.client.AbstractDTClient;
import com.coketea.dt.client.DTClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class BIOSocketClient extends AbstractDTClient {

    static final Logger logger = LoggerFactory.getLogger(BIOSocketClient.class);

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

    public BIOSocketClient() {
        super();
    }

    public BIOSocketClient(String ip, int port) {
        super(ip, port);
    }

    @Override
    public void connect() throws IOException {
        this.clientSocket = new Socket(this.getIp(), this.getPort());
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));
        out = new PrintStream(clientSocket.getOutputStream());
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

    @Override
    public void sendMsg(byte[] msg) throws IOException {
        this.out.write(msg);
        this.out.println();
        this.out.flush();
    }

    @Override
    public String receiveMsg() throws IOException {
        String msg = this.in.readLine();
        logger.debug("msg received from server: {}", msg);
        return msg;
    }
}
