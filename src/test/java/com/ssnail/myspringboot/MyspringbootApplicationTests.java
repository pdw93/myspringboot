package com.ssnail.myspringboot;

import com.ssnail.myspringboot.application.user.User;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyspringbootApplicationTests {
    @Resource
    private JdbcTemplate jdbcTemplate;

    private Connection conn;

    @Before
    public void init() throws Exception{
        conn = jdbcTemplate.getDataSource().getConnection();
    }

    @Test
    public void testTables() throws Exception{
        DatabaseMetaData metaData = conn.getMetaData();

        ResultSet ssnail_pdw = metaData.getTables("ssnail_pdw", "", "ss_user_role", new String[]{"TABLE"});
        while (ssnail_pdw.next()) {
            String table_name = ssnail_pdw.getString("TABLE_NAME");
            System.out.println("数据库表名："+ table_name);
            System.out.println("数据库表备注："+ ssnail_pdw.getString("REMARKS"));

//            ResultSet primaryKeys = metaData.getPrimaryKeys(null, null, table_name);
//            while (primaryKeys.next()) {
//                System.out.println(primaryKeys.getString("COLUMN_NAME"));
//                System.out.println(primaryKeys.getString("KEY_SEQ"));
//                System.out.println(primaryKeys.getString("PK_NAME"));
//            }
            ResultSet columns = metaData.getColumns(null, null, table_name, null);
            while (columns.next()) {
                System.out.println(columns.getString("COLUMN_NAME"));

                System.out.println(columns.getString("TYPE_NAME"));
            }

            System.out.println("-------------------------------");
        }
    }

    /**
     * 获取数据库列表
     *
     * @throws Exception
     */
    @Test
    public void testFindAllCatalogs() throws Exception {
        Connection conn = jdbcTemplate.getDataSource().getConnection();
        DatabaseMetaData metaData = conn.getMetaData();

        // 获取数据库列表
        ResultSet catalogs = metaData.getCatalogs();
        while (catalogs.next()) {
            System.out.println("数据库名：" + catalogs.getString(1));
        }
        catalogs.close();
        conn.close();
    }


    /**
     * 获取数据库元数据
     */
    @Test
    public void testDatabaseMetaData() throws Exception {
        Connection conn = jdbcTemplate.getDataSource().getConnection();
        //获取数据库元数据
        DatabaseMetaData dbMetaData = conn.getMetaData();
        //获取数据库产品名称
        String productName = dbMetaData.getDatabaseProductName();
        System.out.println("获取数据库产品名称：" + productName);
        //获取数据库版本号
        String productVersion = dbMetaData.getDatabaseProductVersion();
        System.out.println("获取数据库版本号：" + productVersion);
        //获取数据库用户名
        String userName = dbMetaData.getUserName();
        System.out.println("获取数据库用户名：" + userName);
        //获取数据库连接URL
        String userUrl = dbMetaData.getURL();
        System.out.println("获取数据库连接URL：" + userUrl);
        //获取数据库驱动
        String driverName = dbMetaData.getDriverName();
        System.out.println("获取数据库驱动：" + driverName);
        //获取数据库驱动版本号
        String driverVersion = dbMetaData.getDriverVersion();
        System.out.println("获取数据库驱动版本号：" + driverVersion);
        //查看数据库是否允许读操作
        boolean isReadOnly = dbMetaData.isReadOnly();
        System.out.println("查看数据库是否允许读操作：" + isReadOnly);
        //查看数据库是否支持事务操作
        boolean supportsTransactions = dbMetaData.supportsTransactions();
        System.out.println("查看数据库是否支持事务操作：" + supportsTransactions);
    }


    @Test
    public void mySqlTest() {
        String sql = "select id, name, password, date_create, date_update from ss_user";
        List<User> users = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setPassWord(rs.getString("password"));
                user.setDateCreate(rs.getDate("date_create"));
                user.setDateUpdate(rs.getDate("date_update"));
                return user;
            }
        });
        System.out.println("query success");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
