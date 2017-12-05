package com.coketea.dt.agent.aop.service;

import org.aspectj.lang.ProceedingJoinPoint;

public interface TransactionServer {

    Object execute(ProceedingJoinPoint point) throws Throwable;
}
