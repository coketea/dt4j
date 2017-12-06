package com.coketea.dt.server.bio;

import com.alibaba.fastjson.JSONObject;
import com.coketea.dt.io.protocol.DTCommunicationMessage;
import com.coketea.dt.io.protocol.MessageHandler;
import com.coketea.dt.server.DTServer;
import com.coketea.dt.server.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class BIORequestHandler implements Runnable, RequestHandler {

    static final Logger logger = LoggerFactory.getLogger(BIORequestHandler.class);

    /**
     * 客户端请求socket对象
     */
    private Socket clientSocket = null;

    /**
     * 持有一个Server对象的引用
     */
    private DTServer server;

    /**
     * 消息处理器
     */
    private MessageHandler messageHandler;

    /**
     * 发送数据的对象
     */
    private PrintStream out;

    /**
     * 接收数据的对象
     */
    private BufferedReader in;

    public BIORequestHandler(DTServer server, Socket clientSocket) {
        this.server = server;
        this.clientSocket = clientSocket;
        this.messageHandler = new BIORequestMessageHandler(this);
    }

    @Override
    public void run() {
        String msg = null;
        try {
            out = new PrintStream(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream(), StandardCharsets.UTF_8));
            while (this.server.isRunning()) {
                msg = in.readLine();
                logger.debug("received message from client:{}", msg);
                DTCommunicationMessage sendMsg = this.messageHandler.handle(msg);
                this.sendMsg(JSONObject.toJSONString(sendMsg));
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

    public MessageHandler getMessageHandler() {
        return messageHandler;
    }

    public void setMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    @Override
    public void addSelfToClientList(String clientId) {
        this.server.addClient(clientId, this);
    }

    @Override
    public void sendMsg(byte[] msg) throws IOException {
        this.out.write(msg);
        this.out.println();
        this.out.flush();
    }

    @Override
    public void sendMsg(String msg) throws IOException {
        this.sendMsg(msg.getBytes(StandardCharsets.UTF_8));
    }
}
