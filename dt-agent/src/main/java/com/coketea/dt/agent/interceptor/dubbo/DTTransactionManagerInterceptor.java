package com.coketea.dt.agent.interceptor.dubbo;

import com.coketea.dt.agent.aop.service.AspectBeforeService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTTransactionManagerInterceptor {

    @Autowired
    private AspectBeforeService aspectBeforeService;

    public Object around(ProceedingJoinPoint point) throws Throwable {
        String groupId = null;
        return aspectBeforeService.around(groupId, point);
    }
}
