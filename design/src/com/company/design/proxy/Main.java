package com.company.design.proxy;

import com.company.design.aop.AopBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        Browser browser = new Browser("www.naver.com");
        browser.show();

        // 캐싱을 사용하지 않으면 매번 로딩을 하게 됨
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        IBrowser browser1 = new BrowserProxy("www.naver.com");
        browser1.show();
        browser1.show();
        browser1.show();
        browser1.show();
        browser1.show();


        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();
        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    end.set(System.currentTimeMillis() - start.get());
                }
        );

        aopBrowser.show();
        System.out.println("Load Time: " + end.get()); // Load Time: 1510

        // 캐싱 후에는 html 페이지 로딩 없이 바로 반환하므로 빠름
        aopBrowser.show();
        System.out.println("Load Time: " + end.get()); // Load Time: 0
    }
}
