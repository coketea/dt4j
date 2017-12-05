package com.coketea.dt.agent.aop.service.impl;

import com.coketea.dt.agent.aop.service.AspectBeforeService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

@Service
public class AspectBeforeServiceImpl implements AspectBeforeService {

    @Override
    public Object around(String groupId, ProceedingJoinPoint point) throws Throwable {
        return point.proceed();
    }
}
