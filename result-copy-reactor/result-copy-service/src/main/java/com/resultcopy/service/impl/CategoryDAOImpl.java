package com.resultcopy.service.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.resultcopy.CategoryResponse;
import com.resultcopy.PatientResultResponse;
import com.resultcopy.service.ConnectionFactory;
import com.resultcopy.service.dao.CategoryDAO;
/**
 * @author AC089545
 */
/**
 * returns category details.
 */
public class CategoryDAOImpl implements CategoryDAO {

    private Connection connection = null;

    public CategoryDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public CategoryDAOImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    public List<CategoryResponse> getCategories() {
        PatientResultResponse patientResult = new PatientResultResponse();
        List<CategoryResponse> categoryList= new ArrayList<>();
        CategoryResponse categoryResponse=null;
        String sql="SELECT * from category";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categoryResponse=new CategoryResponse();
                categoryResponse.setId(resultSet.getInt("CATEGORY_ID"));
                categoryResponse.setDisplayName(resultSet.getString("CATEGORY_NAME"));
                categoryList.add(categoryResponse);
            }
            patientResult = new PatientResultResponse();
            patientResult.setCategory(categoryList);
        }catch (SQLException ex){
            new RuntimeException("SQL Exception occured");
        }
        patientResult.setCategory(categoryList);
        return categoryList;
    }
}
