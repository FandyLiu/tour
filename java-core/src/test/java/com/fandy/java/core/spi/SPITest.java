package com.fandy.java.core.spi;


import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.ServiceLoader;
import sun.misc.Service;

public class SPITest {

    @Test
    public void service() {
        Iterator<SPIService> providers = Service.providers(SPIService.class);
        while (providers.hasNext()) {
            SPIService next = providers.next();
            next.exec();
        }
    }
    @Test
    public void serviceLoader() {
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);
        Iterator<SPIService> providers = load.iterator();
        while (providers.hasNext()) {
            SPIService next = providers.next();
            next.exec();
        }
    }

}
