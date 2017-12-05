package com.coketea.dt.client.bio;

import com.coketea.dt.client.DTClient;

public class BIOSocketClientTest {

    //@Test
    public void testConnect() throws Exception {
        DTClient client = new BIOSocketClient();
        client.connect();
    }
}
