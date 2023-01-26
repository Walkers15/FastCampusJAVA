package chapter3.ch13.web.userinfo;

import chapter3.ch13.domain.userinfo.UserInfo;
import chapter3.ch13.domain.userinfo.UserInfoDao;
import chapter3.ch13.domain.userinfo.dao.mysql.UserInfoMysqlDao;
import chapter3.ch13.domain.userinfo.dao.oracle.UserInfoOracleDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserInfoClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src/chapter3/db.properties");

        Properties prop = new Properties();
        prop.load(fis);

        String dbType = prop.getProperty("DB-TYPE");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("um");
        userInfo.setPassword("asd123");
        userInfo.setUserName("김준식");

        UserInfoDao userInfoDao = null;

        if(dbType.equals("ORACLE")) {
            userInfoDao = new UserInfoOracleDao();
        } else if(dbType.equals("MYSQL")) {
            userInfoDao = new UserInfoMysqlDao();
        } else {
            System.out.println("No Such DB-TYPE Dao");
        }

        if (userInfoDao != null) {
            userInfoDao.insertUserInfo(userInfo);
            userInfoDao.updateUserInfo(userInfo);
            userInfoDao.deleteUserInfo(userInfo);
        }
    }
}
