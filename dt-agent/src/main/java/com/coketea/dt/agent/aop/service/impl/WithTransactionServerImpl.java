package com.coketea.dt.agent.aop.service.impl;

import com.coketea.dt.agent.aop.service.TransactionServer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(value = "withTransactionServer")
public class WithTransactionServerImpl implements TransactionServer {

    static final Logger logger = LoggerFactory.getLogger(WithTransactionServerImpl.class);

    @Override
    public Object execute(ProceedingJoinPoint point) throws Throwable {
        logger.info("withTransactionServer execute");
        return point.proceed();
    }
}
