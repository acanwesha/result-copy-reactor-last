package com.resultcopy.service.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.resultcopy.PatientDetailsResponse;
import com.resultcopy.PatientResponse;
import com.resultcopy.service.ConnectionFactory;
import com.resultcopy.service.dao.PatientDAO;
/**
 * @author AC089545
 */
/**
 * returns the patient details.
 */
public class PatientDAOImpl implements PatientDAO {
    private Connection connection = null;

    public PatientDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public PatientDAOImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    /**
     * @param patientId
     *          patientId is the unique identifier for the patient.
     */
    @Override
    public PatientResponse getPatientById(Integer patientId) {
        PatientResponse patient = null;
        PatientDetailsResponse patientDetailsResponse = null;
        String sql = " SELECT * FROM patient WHERE PATIENT_ID =  "+patientId;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                patientDetailsResponse= new PatientDetailsResponse();
                patientDetailsResponse.setId(resultSet.getInt("PATIENT_ID"));
                patientDetailsResponse.setFirstName(resultSet.getString("FIRST_NAME"));
                patientDetailsResponse.setLastName(resultSet.getString("LAST_NAME"));
                patientDetailsResponse.setMrn(resultSet.getString("MRN"));
                patientDetailsResponse.setFin(resultSet.getString("FIN"));
            }
            patient = new PatientResponse();
            patient.setPatientDetails(patientDetailsResponse);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return patient;
    }
}
