package com.company.design.proxy;

public class Browser implements IBrowser{
    public String url;

    public Browser(String url) {
        this.url = url;
    }

    @Override
    public Html show() {
        System.out.println("Browser Loading html from: " + url);
        return new Html(url);
    }
}
