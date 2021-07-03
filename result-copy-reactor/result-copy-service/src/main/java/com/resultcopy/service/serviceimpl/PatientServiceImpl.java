package com.resultcopy.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import com.resultcopy.BabyResultResponse;
import com.resultcopy.CategoryResponse;
import com.resultcopy.ChildResponse;
import com.resultcopy.ChildResultResponse;
import com.resultcopy.PatientDetailsResponse;
import com.resultcopy.PatientResponse;
import com.resultcopy.PatientResultResponse;
import com.resultcopy.ResultResponse;
import com.resultcopy.service.dao.BabyResultDAO;
import com.resultcopy.service.dao.CategoryDAO;
import com.resultcopy.service.dao.ChildDAO;
import com.resultcopy.service.dao.PatientDAO;
import com.resultcopy.service.dao.ResultDAO;
import com.resultcopy.service.impl.BabyResultDAOImpl;
import com.resultcopy.service.impl.CategoryDAOImpl;
import com.resultcopy.service.impl.ChildDAOImpl;
import com.resultcopy.service.impl.PatientDAOImpl;
import com.resultcopy.service.impl.ResultDAOImpl;
/**
 * @author AC089545
 */
/**
 * returns the patient result.
 */
public class PatientServiceImpl {
    PatientDAO patientDAO;
    ChildDAO childDAO;
    ResultDAO resultDAO;
    CategoryDAO categoryDAO;
    BabyResultDAO babyResultDAO;

   public PatientServiceImpl() {
        this.patientDAO = new PatientDAOImpl();
        this.childDAO = new ChildDAOImpl();
        this.resultDAO = new ResultDAOImpl();
        this.categoryDAO = new CategoryDAOImpl();
        this.babyResultDAO = new BabyResultDAOImpl();
    }

    public PatientServiceImpl(PatientDAO patientDAO, ChildDAO childDAO, ResultDAO resultDAO,
                              CategoryDAO categoryDAO, BabyResultDAO babyResultDAO) {
        this.patientDAO = patientDAO;
        this.childDAO = childDAO;
        this.resultDAO = resultDAO;
        this.categoryDAO = categoryDAO;
        this.babyResultDAO = babyResultDAO;
    }

    public PatientResultResponse getPatientDetails(String patientId){

        PatientResultResponse patient = new PatientResultResponse();
        PatientResponse patientResponse =patientDAO.getPatientById(Integer.parseInt(patientId));
        List<PatientDetailsResponse> patientDetailsList = childDAO.getPatientById(Integer.parseInt(patientId));
        List<ChildResponse> childResponseList = new ArrayList<>();
        ChildResponse childResponse = new ChildResponse();
        childResponse.setChildDetails(patientDetailsList);
        childResponseList.add(childResponse);

        List<CategoryResponse> categoryList = categoryDAO.getCategories();

        for(PatientDetailsResponse patientDetail:patientDetailsList) {
            BabyResultResponse babyResultResponse = babyResultDAO.getBabyPatientByChildId(patientDetail.getId());
            if(null!=babyResultResponse){
                patientDetail.setResultCopiedDateTime(babyResultResponse.getDateTime());
            }else {
                patient.setCategory(categoryList);
                for(CategoryResponse category:categoryList) {
                    List<ChildResultResponse> childResultsList =resultDAO.getChildValueById(Integer.parseInt(patientId));
                    List<ResultResponse> resultList = resultDAO.getCategories(category.getId());
                    ResultResponse resultDto=null;
                    for (ChildResultResponse childResultResponse : childResultsList) {
                        resultDto = new ResultResponse();
                        for(ResultResponse result :resultList) {
                            if (result.getId() == childResultResponse.getResultId()) {
                                result.setValue(childResultResponse.getValue());
                            }
                        }
                    }
                    resultList.add(resultDto);
                    category.setResult(resultList);
                }
            }
        }
        patient.setPatient(patientResponse);
        patient.setChild(childResponseList);
        return patient;
    }
}
