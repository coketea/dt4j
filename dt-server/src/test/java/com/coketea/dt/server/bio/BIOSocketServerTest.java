package com.coketea.dt.server.bio;

import com.coketea.dt.server.Server;
import org.junit.Test;

public class BIOSocketServerTest {

    @Test
    public void testStartup() throws Exception {
        Server server = new BIOSocketServer();
        server.startup();
    }
}
