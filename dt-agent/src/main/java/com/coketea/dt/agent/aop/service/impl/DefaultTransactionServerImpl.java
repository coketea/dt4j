package com.coketea.dt.agent.aop.service.impl;

import com.coketea.dt.agent.aop.service.TransactionServer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(value = "defaultTransactionServer")
public class DefaultTransactionServerImpl implements TransactionServer {

    static final Logger logger = LoggerFactory.getLogger(DefaultTransactionServerImpl.class);

    @Override
    public Object execute(ProceedingJoinPoint point) throws Throwable {
        logger.info("defaultTransactionServer execute");
        return point.proceed();
    }
}
