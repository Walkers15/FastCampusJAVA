package com.company.design.proxy;

public class BrowserProxy implements IBrowser {
    private String url;
    private Html html;

    public BrowserProxy(String url) {
        this.url = url;
    }

    @Override
    public Html show() {
        if (html == null) {
            System.out.println("BrowserProxy Loading html from: " + url);
            this.html = new Html(this.url);
        }
        System.out.println("BrowserProxy Using Html Cache");
        return this.html;
    }
}
