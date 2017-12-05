package com.coketea.dt.server.bio;

import com.coketea.dt.server.DTServer;
import org.junit.Test;

public class BIOSocketServerTest {

    //@Test
    public void testStartup() throws Exception {
        DTServer server = new BIOSocketServer();
        server.startup();
    }
}
