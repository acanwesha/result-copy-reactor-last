package com.resultcopy.service.dao;

import com.resultcopy.BabyRequest;
import com.resultcopy.BabyResultResponse;

/**
 * @author AC089545
 * Interface BabyResultDAO containing all the methods to get the child result.
 */
public interface BabyResultDAO {

    /**
     * The method is used to get the
     * @param childId
     * @return
     */
    BabyResultResponse getBabyPatientByChildId(Integer childId);
    public boolean createBabyResult(BabyRequest babyRequest );
}
