package com.example.demo.service;

import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeRepositoryy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeSevice {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeRepositoryy employeeRepositoryy;

    public EmployeeModel save(EmployeeModel emp) {
        emp.setJoiningDate(new Date());
        return employeeRepository.save(emp);

    }

    public List<EmployeeModel> getAll() {
        return employeeRepository.find();

    }

    public EmployeeModel update(EmployeeModel emp) {
        return employeeRepository.save(emp);
    }



    public List<EmployeeModel> getBySalary(int salary, String firstName,String lastName) {
      return   employeeRepository.findBySalary(salary,firstName,lastName);
    }

    public List<EmployeeModel> getByFirstName(String firstName) {
        return   employeeRepository.findByFirstName(firstName);
    }

    public long delete(EmployeeModel emp) {
        return employeeRepository.delete(emp);
    }

    public Map<String, Object> getAllEmployeePage(int pageNo, int pageSize, String sortBy) {
        Map<String, Object> reponse=new HashMap<String, Object>();
        Sort sort=Sort.by(sortBy);
        Pageable page= PageRequest.of(pageNo,pageSize,sort);
        Page<EmployeeModel> employeeModelPage=employeeRepositoryy.findAll(page);
        reponse.put("data",employeeModelPage.getContent());
        reponse.put("ToTal no of page",employeeModelPage.getTotalPages());
        reponse.put("ToTal no of Elements",employeeModelPage.getTotalElements());
        reponse.put("Curent page no",employeeModelPage.getNumber());
        return reponse;

    }
}
