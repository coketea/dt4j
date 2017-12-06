package com.coketea.dt.io.protocol;

public interface MessageHandler {

    DTCommunicationMessage handle(String msg);

}
