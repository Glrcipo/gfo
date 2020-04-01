package com.gfo.gfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GfoApplicationTests {
    @Autowired
    private DataSource dataSource;

    @Test
    public void getConnection() throws SQLException {
        System.err.println(dataSource.getConnection());
    }
}
