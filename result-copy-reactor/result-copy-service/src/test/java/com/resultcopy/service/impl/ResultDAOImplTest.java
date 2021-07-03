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
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.resultcopy.ChildResultResponse;
import com.resultcopy.ResultResponse;
import com.resultcopy.service.ConnectionFactory;

import lombok.ToString;

@ToString
@RunWith(PowerMockRunner.class)
@PrepareForTest(ConnectionFactory.class)
public class ResultDAOImplTest {

    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;

    @Test
    public void testCategoryDAOImpl() throws SQLException {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setId(12);
        resultResponse.setDisplayName("PREGNANCY_OUTCOME");
        resultResponse.setValue("VAGINAL_BIRTH");

        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.first()).thenReturn(true);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getInt(any(String.class))).thenReturn(resultResponse.getId());
        when(resultSet.getString("RESULT_NAME")).thenReturn(resultResponse.getDisplayName());

        List<ResultResponse> result = new ResultDAOImpl(connection).getCategories(12);
        Assertions.assertEquals(result.listIterator().next().getDisplayName(), resultResponse.getDisplayName());
        Assertions.assertEquals(result.listIterator().next().getId(), resultResponse.getId());
    }

    @Test
    public void testExceptionGetCategories() throws SQLException {

        when(connection.prepareStatement(any(String.class))).thenThrow((new SQLException()));
        List<ResultResponse> result = new ResultDAOImpl(connection).getCategories(12);
        Assertions.assertEquals(result, Collections.emptyList());
    }

    @Test
    public void testExceptionGetChildValueById() throws SQLException {

        when(connection.prepareStatement(any(String.class))).thenThrow((new SQLException()));
        List<ChildResultResponse> result = new ResultDAOImpl(connection).getChildValueById(12);
        Assertions.assertEquals(result, Collections.emptyList());
    }

    @Test
    public void testConstructor() {
        PowerMockito.mockStatic(ConnectionFactory.class);
        when(ConnectionFactory.getConnection()).thenReturn(connection);
        ResultDAOImpl resultDAOImpl = new ResultDAOImpl();
        Assertions.assertNotNull(resultDAOImpl);
    }

    @Test
    public void getChildValueById() throws SQLException {
        ChildResultResponse patientResponse = new ChildResultResponse();
        patientResponse.setChildId(11);
        patientResponse.setResultId(20);
        patientResponse.setValue("VAGINAL_BIRTH");

        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.first()).thenReturn(true);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getInt("CHILD_ID")).thenReturn(patientResponse.getChildId());
        when(resultSet.getInt("RESULT_ID")).thenReturn(patientResponse.getResultId());
        when(resultSet.getString("VALUE")).thenReturn(patientResponse.getValue());

        List<ChildResultResponse> result = new ResultDAOImpl(connection).getChildValueById(11);
        Assertions.assertEquals(result.listIterator().next().getResultId(), patientResponse.getResultId());
        Assertions.assertEquals(result.listIterator().next().getChildId(), patientResponse.getChildId());
        Assertions.assertEquals(result.listIterator().next().getValue(), patientResponse.getValue());
    }
}