package com.resultcopy.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import lombok.ToString;

@ToString
@RunWith(PowerMockRunner.class)
@PrepareForTest({
        ConnectionFactory.class,
        DriverManager.class
})
public class ConnectionFactoryTest {

    @Mock
    private Connection connection;

    @Test
    public void testConnection() throws Exception {
        PowerMockito.mockStatic(DriverManager.class);
        when(DriverManager.getConnection(any(String.class),any(String.class),any(String.class))).thenReturn(connection);
        Connection connection = ConnectionFactory.getConnection();
        Assertions.assertNotNull(connection);
    }

    @Test(expected = RuntimeException.class)
    public void testCatchStatement() throws SQLException{
        PowerMockito.mockStatic(DriverManager.class);
        when(DriverManager.getConnection(any(String.class),any(String.class),any(String.class))).thenThrow(new SQLException());
        Connection connection = ConnectionFactory.getConnection();
        Assertions.assertNotNull(connection);
    }

}