package com.resultcopy.service.impl;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.resultcopy.CategoryResponse;
import com.resultcopy.service.ConnectionFactory;

import lombok.ToString;

@ToString
@RunWith(PowerMockRunner.class)
@PrepareForTest(ConnectionFactory.class)
public class CategoryDAOImplTest {

    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;

    @Test
    public void testCategoryDAOImpl() throws SQLException {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(12);
        categoryResponse.setDisplayName("DELIVERY_INFORMATION");

        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.first()).thenReturn(true);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getInt(any(String.class))).thenReturn(categoryResponse.getId());
        when(resultSet.getString(any(String.class))).thenReturn(categoryResponse.getDisplayName());

        List<CategoryResponse> categoryResponseList1 = new CategoryDAOImpl(connection).getCategories();
        CategoryResponse result = categoryResponseList1.listIterator().next();
        Assertions.assertEquals(categoryResponse.getDisplayName(), result.getDisplayName());
        Assertions.assertEquals(categoryResponse.getId(), result.getId());
    }

    @Test
    public void testException() throws SQLException {

        when(connection.prepareStatement(any(String.class))).thenThrow((new SQLException()));
        List<CategoryResponse> categoryResponseList1 = new CategoryDAOImpl(connection).getCategories();
        Assertions.assertEquals(categoryResponseList1, Collections.emptyList());
    }

    @Test
    public void testConstructor() {
        PowerMockito.mockStatic(ConnectionFactory.class);
        when(ConnectionFactory.getConnection()).thenReturn(connection);
        CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
        Assertions.assertNotNull(categoryDAOImpl);
    }

}