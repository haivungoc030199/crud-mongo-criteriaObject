package com.example.demo.repository;

import com.example.demo.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class EmployeeRepository   {
    @Autowired
    MongoTemplate mongoTemplate;



    public EmployeeModel save(EmployeeModel emp) {
        return  mongoTemplate.save(emp);

    }

    public List<EmployeeModel> find() {
        return  mongoTemplate.findAll(EmployeeModel.class);

    }

    public long delete(EmployeeModel emp) {
        return mongoTemplate.remove(emp).getDeletedCount();
    }

    public List<EmployeeModel> findBySalary(int salary, String firstName,String lastName) {
        Criteria criteria =
                Criteria.where("salary").gte(salary)
                        .and("firstName").regex("^"+firstName)
                        .and("lastName").is(lastName);

        Query query=new Query(criteria);
        return mongoTemplate.find(query,EmployeeModel.class);



        /*Criteria criteria=new Criteria();

        String query= String.valueOf(criteria.andOperator(Criteria.where("salary").gte(salary)));

        return mongoTemplate.find(query,EmployeeModel.class);*/
    }

    public List<EmployeeModel> findByFirstName(String firstName) {
        Query query=new Query(Criteria.where("firstName").regex("^"+firstName));
        return mongoTemplate.find(query,EmployeeModel.class);
    }


}
