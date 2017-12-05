package com.coketea.dt.agent.aop.service.impl;

import com.coketea.dt.agent.aop.service.TransactionServer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(value = "startTransactionServer")
public class StartTransactionServerImpl implements TransactionServer {

    static final Logger logger = LoggerFactory.getLogger(StartTransactionServerImpl.class);

    @Override
    public Object execute(ProceedingJoinPoint point) throws Throwable {
        logger.info("startTransactionServer execute");
        return point.proceed();
    }
}
