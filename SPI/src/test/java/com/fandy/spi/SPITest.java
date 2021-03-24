package com.fandy.spi;

import org.junit.Test;
import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

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
