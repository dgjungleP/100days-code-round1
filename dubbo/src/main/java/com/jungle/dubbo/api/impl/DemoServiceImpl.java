package com.jungle.dubbo.api.impl;

import com.jungle.dubbo.api.DemoService;
import org.apache.dubbo.rpc.RpcContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        System.out.println("【" + new SimpleDateFormat("HH:mm:ss")
                .format(new Date()) + "】 Hello " + name + ". request from:【" + RpcContext.getContext()
                .getRemoteAddressString() + "】");
        return "Hello " + name + ". request from:【" + RpcContext.getContext()
                .getRemoteAddressString() + "】";
    }
}
