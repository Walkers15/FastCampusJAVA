package com.company.design.singleton;

import com.company.design.singleton.AClazz;
import com.company.design.singleton.BClazz;
import com.company.design.singleton.SocketClient;

public class Main {
    public static void main(String[] args) {
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        // 싱글톤으로 하나의 인스턴스를 유지하고 있으므로 true 가 출력됨
        System.out.println(aClient.equals(bClient)); // true
    }


}
