package com.resultcopy.service.dao;

import com.resultcopy.CategoryResponse;
import java.util.List;

/**
 * @author AC089545
 * <p>
     Interface CategoryDAO containing all the methods to get the list of
     categories and the respective results associated with categories.
 * </p>
 */
public interface CategoryDAO {
    public List<CategoryResponse> getCategories() ;
}
