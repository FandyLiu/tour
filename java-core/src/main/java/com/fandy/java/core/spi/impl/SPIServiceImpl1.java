package com.fandy.java.core.spi.impl;


import com.fandy.java.core.spi.SPIService;

public class SPIServiceImpl1 implements SPIService {
    @Override
    public void exec() {
        System.out.println("SPIServiceImpl1.exec()");
    }
}
