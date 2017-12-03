package com.coketea.dt.client.bio;

import com.coketea.dt.client.Client;
import org.junit.Test;

public class BIOSocketClientTest {

    @Test
    public void testConnect() throws Exception {
        Client client = new BIOSocketClient();
        client.connect();
    }
}
