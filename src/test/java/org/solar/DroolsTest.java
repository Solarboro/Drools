package org.solar;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.solar.entity.Order;

public class DroolsTest {
    @Test
    public void test(){
        KieServices ks = KieServices.Factory.get();

        KieContainer kc = ks.newKieClasspathContainer();

        KieSession kieSession = kc.newKieSession();


        Order order = new Order();
        order.setOriginalPrice(50d);
        Order order1 = new Order();
        order1.setOriginalPrice(150d);


        System.out.println("--------order1. real Price");
        System.out.println(order.getRealPrice());

        System.out.println("--------order2. real price");
        System.out.println(order1.getRealPrice());
        kieSession.insert(order);
        kieSession.insert(order1);
        kieSession.fireAllRules();

        System.out.println("order1. real Price");
        System.out.println(order.getRealPrice());

        System.out.println("order2. real price");
        System.out.println(order1.getRealPrice());
        kieSession.destroy();
    }
}
