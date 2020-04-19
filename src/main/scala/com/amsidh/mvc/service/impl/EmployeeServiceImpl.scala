package com.amsidh.mvc.service.impl

import com.amsidh.mvc.model.Employee
import com.amsidh.mvc.repository.EmployeeRepository
import com.amsidh.mvc.service.EmployeeTrait
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl(@Autowired employeeRepository: EmployeeRepository) extends EmployeeTrait {
    override def addEmployee(employee: Employee): Unit = {
        employeeRepository.save(employee)
    }

    override def updateEmployee(id: Int, employee: Employee): Employee = {
        var emp: Employee = employeeRepository.findById(id).get();
        if (emp != null) {
            emp.employeeName = employee.employeeName
            emp.salary = employee.salary
            emp.mobileNumber = employee.mobileNumber
            emp.emailId = employee.emailId
        }
        emp
    }

    override def deleteEmployee(id: Int): Unit = {
        employeeRepository.deleteById(id)
    }

    override def employeeById(id: Int): Employee = {
        employeeRepository.findById(id).get()
    }

    override def employees(): java.lang.Iterable[Employee] = {
        employeeRepository.findAll()
    }
}
