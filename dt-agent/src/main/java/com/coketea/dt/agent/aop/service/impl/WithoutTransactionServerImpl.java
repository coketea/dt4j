package com.coketea.dt.agent.aop.service.impl;

import com.coketea.dt.agent.aop.service.TransactionServer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(value = "withoutTransactionServer")
public class WithoutTransactionServerImpl implements TransactionServer {

    static final Logger logger = LoggerFactory.getLogger(WithoutTransactionServerImpl.class);

    @Override
    public Object execute(ProceedingJoinPoint point) throws Throwable {
        logger.info("withoutTransactionServer execute");
        return point.proceed();
    }
}
