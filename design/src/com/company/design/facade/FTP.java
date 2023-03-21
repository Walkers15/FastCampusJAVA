package com.company.design.facade;

public class FTP {
    private String host;
    private int port;
    private String path;

    public FTP(String host, int port, String path) {
        this.host = host;
        this.port = port;
        this.path = path;
    }

    public void connect() {
        System.out.println("Connect to FTP Host: " + this.host + " Port: " + this.port);
    }

    public void disconnect() {
        System.out.println("Host Disconnect " + this.host);

    }
    public void cd() {
        System.out.println("path: " + path + "로 이동합니다.");
    }


}
