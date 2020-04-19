package com.amsidh.mvc.service

import com.amsidh.mvc.model.Employee

trait EmployeeTrait {
    def addEmployee(employee: Employee): Unit;

    def updateEmployee(id: Int, employee: Employee): Employee;

    def deleteEmployee(id: Int): Unit;

    def employeeById(id: Int): Employee;

    def employees(): java.lang.Iterable[Employee];
}
