package com.company.design.facade;

public class Writer {
    private String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    public void openFile() {
        String msg = String.format("Writer %s 로 연결합니다.", this.fileName);
        System.out.println(msg);
    }

    public void fileWrite() {
        System.out.printf("%s에 데이터 쓰는 중\n", this.fileName);
    }

    public void closeFile() {
        System.out.printf("Writer Close FIle %s\n", this.fileName);
    }
}
