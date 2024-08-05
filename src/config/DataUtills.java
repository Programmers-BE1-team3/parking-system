package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataUtills {
    public static final String url = "jdbc:mysql://127.0.0.1:3306/parkingsystem";
    public static final String user = "아이디";
    public static final String password = "비밀번호";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;

        try{
            conn = DriverManager.getConnection(url, user, password);
        }catch (SQLException e){
            System.out.println("커넥션 생성 오류");
            e.printStackTrace();
        }
        return conn;

    }


    public static void close(AutoCloseable... closebles){
        for(AutoCloseable closeble : closebles){
            if(closeble != null){
                try {
                    closeble.close();
                } catch (Exception e) {
                    System.out.println("close 하다가 에러나느거 아직까지 못보긴 했음");
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
