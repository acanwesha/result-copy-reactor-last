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

import com.resultcopy.PatientDetailsResponse;
import com.resultcopy.service.ConnectionFactory;

import lombok.ToString;

@ToString
@RunWith(PowerMockRunner.class)
@PrepareForTest(ConnectionFactory.class)
public class ChildDAOImplTest {

    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;

    @Test
    public void getPatientById() throws SQLException {

        PatientDetailsResponse childDetails = new PatientDetailsResponse();
        childDetails.setId(1);
        childDetails.setFirstName("AARAV");
        childDetails.setLastName("ESPINOSA");
        childDetails.setMrn("MX12345");
        childDetails.setFin("MH54321");

        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.first()).thenReturn(true);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getInt(any(String.class))).thenReturn(childDetails.getId());
        when(resultSet.getString("FIRST_NAME")).thenReturn(childDetails.getFirstName());
        when(resultSet.getString("LAST_NAME")).thenReturn(childDetails.getLastName());
        when(resultSet.getString("MRN")).thenReturn(childDetails.getMrn());
        when(resultSet.getString("FIN")).thenReturn(childDetails.getFin());

        List<PatientDetailsResponse> result = new ChildDAOImpl(connection).getPatientById(1);
        Assertions.assertEquals(result.listIterator().next().getId(), childDetails.getId());
        Assertions.assertEquals(result.listIterator().next().getFirstName(), childDetails.getFirstName());
        Assertions.assertEquals(result.listIterator().next().getLastName(), childDetails.getLastName());
    }

    @Test
    public void testException() throws SQLException {

        when(connection.prepareStatement(any(String.class))).thenThrow((new SQLException()));
        List<PatientDetailsResponse> result = new ChildDAOImpl(connection).getPatientById(1);
        Assertions.assertEquals(result, Collections.emptyList());
    }

    @Test
    public void testConstructor() {
        PowerMockito.mockStatic(ConnectionFactory.class);
        when(ConnectionFactory.getConnection()).thenReturn(connection);
        ChildDAOImpl childDAOImpl = new ChildDAOImpl();
        Assertions.assertNotNull(childDAOImpl);
    }

}


