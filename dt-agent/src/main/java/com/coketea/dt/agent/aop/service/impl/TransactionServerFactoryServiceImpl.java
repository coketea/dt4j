package com.coketea.dt.agent.aop.service.impl;

import com.coketea.dt.agent.aop.service.TransactionServer;
import com.coketea.dt.agent.aop.service.TransactionServerFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TransactionServerFactoryServiceImpl implements TransactionServerFactoryService {

    @Resource
    private TransactionServer startTransactionServer;

    @Resource
    private TransactionServer withTransactionServer;

    @Resource
    private TransactionServer defaultTransactionServer;

    @Resource
    private TransactionServer withoutTransactionServer;

    @Override
    public TransactionServer createTransactionServer() throws Throwable {
        return defaultTransactionServer;
    }
}
