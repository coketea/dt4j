package com.coketea.dt.coordinator.init;

import com.coketea.dt.server.DTServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitializer implements ApplicationListener<ContextRefreshedEvent> {

    static final Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);

    @Autowired
    private DTServer dtServer;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //当spring父容器初始化完毕时，开始应用程序自身初始化
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            logger.info("start to init application self after spring context inited");

            try {
                dtServer.startup();
            } catch (Exception e) {
                logger.error("dtServer startup failed", e);
            }
        }
    }
}
