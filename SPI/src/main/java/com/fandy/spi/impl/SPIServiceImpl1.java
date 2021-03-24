package com.fandy.spi.impl;

import com.fandy.spi.SPIService;

public class SPIServiceImpl1 implements SPIService {
    @Override
    public void exec() {
        System.out.println("SPIServiceImpl1.exec()");
    }
}
