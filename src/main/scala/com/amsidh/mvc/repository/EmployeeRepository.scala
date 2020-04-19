package com.amsidh.mvc.repository

import com.amsidh.mvc.model.Employee
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
trait EmployeeRepository extends CrudRepository[Employee,Int] {

}
