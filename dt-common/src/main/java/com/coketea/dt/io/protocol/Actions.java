package com.coketea.dt.io.protocol;

public class Actions {

    private Actions() {}

    /**
     * 客户端将自己注册到服务器端
     */
    public static final String REGISTER = "1";

    /**
     * 应答相应的操作成功<br/>
     * 可以是服务器应答客户端，也可以是客户端应答服务器端
     */
    public static final String ACK_SUCCESS = "2";

    /**
     * 应答相应的操作失败<br/>
     * 可以是服务器应答客户端，也可以是客户端应答服务器端
     */
    public static final String ACK_FAILED = "3";

}
