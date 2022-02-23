package com.example.demo.controller;

import com.example.demo.model.EmployeeModel;
import com.example.demo.service.EmployeeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeSevice employeeSevice;

    @PostMapping("/")
    public EmployeeModel save(@RequestBody EmployeeModel emp)
    {
        return employeeSevice.save(emp);
    }
    @GetMapping("/")
    public List<EmployeeModel> getAll()
    {
        return employeeSevice.getAll();
    }
    @PutMapping("/")
    public EmployeeModel update(@RequestBody EmployeeModel emp)
    {
        return employeeSevice.update(emp);
    }
    @DeleteMapping("/")
    public long delele(@RequestBody EmployeeModel emp)
    {
        return employeeSevice.delete(emp);
    }
    //find theo salary - >=
    @GetMapping("/salary")
    /*@RequestMapping("/firstName")
    @RequestMapping("/lastName")*/
    public List<EmployeeModel> getBySalary(@PathParam("salary") int salary,@PathParam("firstName") String firstName,@PathParam("lastName") String lastName)
    {
        return employeeSevice.getBySalary(salary,firstName,lastName);
    }
    //find theo fistName-drugCode
    @GetMapping("/firstName")
    public List<EmployeeModel> getByFirstName(@PathParam("firstName") String firstName)
    {
        return employeeSevice.getByFirstName(firstName);
    }
    @GetMapping("/page")
    public Map<String,Object> getAllEmployeePage(@RequestParam(name = "pageNo",defaultValue = "0") int pageNo,
                                                 @RequestParam(name = "pageSize",defaultValue = "2") int pageSize,
                                                 @RequestParam(name = "sortBy",defaultValue = "fistName") String sortBy
                                                 )
    {
        return employeeSevice.getAllEmployeePage(pageNo,pageSize,sortBy);
    }

}
