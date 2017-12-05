package com.coketea.dt.agent.aop.service;

import org.aspectj.lang.ProceedingJoinPoint;

public interface AspectBeforeService {

    Object around(String groupId, ProceedingJoinPoint point) throws Throwable;

}
