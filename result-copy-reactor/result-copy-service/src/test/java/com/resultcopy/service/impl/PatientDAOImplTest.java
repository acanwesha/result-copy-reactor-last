package com.resultcopy.service.impl;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.resultcopy.PatientDetailsResponse;
import com.resultcopy.PatientResponse;
import com.resultcopy.service.ConnectionFactory;

import lombok.ToString;

@ToString
@RunWith(PowerMockRunner.class)
@PrepareForTest(ConnectionFactory.class)
public class PatientDAOImplTest {

    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;

    @Test
    public void getPatientById() throws SQLException {

        PatientDetailsResponse patientDetails = new PatientDetailsResponse();

        patientDetails.setId(1);
        patientDetails.setFirstName("EMMA");
        patientDetails.setLastName("ESPINOSA");
        patientDetails.setMrn("MX13216584");
        patientDetails.setFin(" MX26548913");

        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.first()).thenReturn(true);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getInt(any(String.class))).thenReturn(patientDetails.getId());
        when(resultSet.getString("FIRST_NAME")).thenReturn(patientDetails.getFirstName());
        when(resultSet.getString("LAST_NAME")).thenReturn(patientDetails.getLastName());
        when(resultSet.getString("MRN")).thenReturn(patientDetails.getMrn());
        when(resultSet.getString("FIN")).thenReturn(patientDetails.getFin());

        PatientResponse result = new PatientDAOImpl(connection).getPatientById(1);
        Assertions.assertEquals(result.getPatientDetails().getId(), patientDetails.getId());
        Assertions.assertEquals(result.getPatientDetails().getFirstName(), patientDetails.getFirstName());
        Assertions.assertEquals(result.getPatientDetails().getLastName(), patientDetails.getLastName());

    }

    @Test
    public void testException() throws SQLException {

        when(connection.prepareStatement(any(String.class))).thenThrow((new SQLException()));
        PatientResponse result = new PatientDAOImpl(connection).getPatientById(1);
        Assertions.assertNull(result);
    }

    @Test
    public void testConstructor() {
        PowerMockito.mockStatic(ConnectionFactory.class);
        when(ConnectionFactory.getConnection()).thenReturn(connection);
        PatientDAOImpl patientDAOImpl = new PatientDAOImpl();
        Assertions.assertNotNull(patientDAOImpl);
    }
}
