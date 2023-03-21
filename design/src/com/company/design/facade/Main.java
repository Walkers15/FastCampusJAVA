package com.company.design.facade;

public class Main {
    public static void main(String[] args) {
        // 파사트 패턴 사용하지 않은 경우
        // 이렇게 클라이언트에서 모든 클래스의 종속성을 가지고 상세한 구현을 직접 해야 함
        FTP ftpClient = new FTP("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.cd();

        Writer writer = new Writer("temp.txt");
        writer.openFile();
        writer.fileWrite();

        Reader reader = new Reader("temp.txt");
        reader.openFile();
        reader.fileRead();

        reader.closeFile();
        writer.closeFile();
        ftpClient.disconnect();


        // 파사드 사용
        // 각 객체에 의존하는것보다 하나의 인터페이스를 두는 것이 더 깔끔함
        SFTPClient sftpClient = new SFTPClient("www.foo.co.kr", 22, "/home/etc", "temp.txt");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disconnect();


    }
}
