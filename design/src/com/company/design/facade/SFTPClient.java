package com.company.design.facade;

public class SFTPClient {
    private FTP ftp;
    private Reader reader;
    private Writer writer;

    public SFTPClient(FTP ftp, Reader reader, Writer writer) {
        this.ftp = ftp;
        this.reader = reader;
        this.writer = writer;
    }

    public SFTPClient(String host, int port, String path, String fileName) {
        this.ftp = new FTP(host, port, path);
        this.reader = new Reader(fileName);
        this.writer = new Writer(fileName);
    }

    public void connect() {
        ftp.connect();
        ftp.cd();
        writer.openFile();
        reader.openFile();
    }

    public void disconnect() {
        writer.closeFile();
        reader.closeFile();
        ftp.disconnect();
    }

    public void read() {
        reader.fileRead();
    }

    public void write() {
        writer.fileWrite();
    }
}
