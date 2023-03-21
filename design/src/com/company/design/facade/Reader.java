package com.company.design.facade;

public class Reader {
    private String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public void openFile() {
        String msg = String.format("Reader %s 로 연결합니다.", this.fileName);
        System.out.println(msg);
    }

    public void fileRead() {
        System.out.printf("%s 로부터 데이터 읽는 중\n", this.fileName);
    }

    public void closeFile() {
        System.out.printf("Reader Close FIle %s\n", this.fileName);
    }
}
