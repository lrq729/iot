package org.jeecgframework.web.demo.service.impl.test;

/**
 * Created by Administrator on 2017-8-11.
 */


import org.jeecgframework.web.demo.service.test.TaskServiceI;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;



import org.springframework.stereotype.Service;

import static javax.print.attribute.standard.MediaSizeName.D;

@Service("taskService")

public class TaskServiceImpl implements TaskServiceI {

    private static  String URL = "jdbc:sqlserver://192.168.99.159:1433;databaseName=ekito6";
    private static  String USER = "sa";
    private static  String PASSWORD = "kitodatabase";

    public void test1() {
        org.jeecgframework.core.util.LogUtil.info(new Date().getTime());
        org.jeecgframework.core.util.LogUtil.info("---定时任务测试---");
        List L = new ArrayList();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = con.createStatement();
            ResultSet rSet = statement.executeQuery("SELECT Name,BirthDate from hrstaffinfo");

            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
            String D = sdf.format(new Date());

            while (rSet.next()) {
                String n = rSet.getString("Name");
                String str = rSet.getString("BirthDate");
                if (str != null && n != null) {
                    String d = str.substring(5, 10);
                    if (d.equals(D)) {
                        L.add(n);
                    }
                }
            }

            rSet.close();
            statement.close();
            con.close();

        }catch(Exception E){
            E.printStackTrace();
        }
        System.out.println(L);
    }
}


