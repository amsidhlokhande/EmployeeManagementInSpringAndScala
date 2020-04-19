package com.amsidh.mvc.controller

import com.amsidh.mvc.model.Employee
import com.amsidh.mvc.service.EmployeeTrait
import java.util.function.Consumer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{MediaType, ResponseEntity}
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("/emp"))
class EmployeeController(@Autowired employeeTrait: EmployeeTrait) {

    @RequestMapping(value = Array("/employees"), method = Array(RequestMethod.GET), produces = Array(MediaType.APPLICATION_JSON_VALUE))
    //@GetMapping(path = Array("/employees"), produces = Array(MediaType.APPLICATION_JSON_VALUE))
    @ResponseBody
    def allEmployees(): ResponseEntity[java.lang.Iterable[Employee]] = {
        ResponseEntity.ok().body(employeeTrait.employees());
    }

    @RequestMapping(value = Array("/employees/save"), method = Array(RequestMethod.POST), consumes = Array(MediaType.APPLICATION_JSON_VALUE), produces = Array(MediaType.APPLICATION_JSON_VALUE))
    //@PostMapping(path = Array("/employees/save"), consumes = Array(MediaType.APPLICATION_JSON_VALUE), produces = Array(MediaType.APPLICATION_JSON_VALUE))
    @ResponseBody
    def addEmployee(@RequestBody employee: Employee): ResponseEntity[java.lang.Iterable[Employee]] = {
        employeeTrait.addEmployee(employee)
        employeeTrait.employees().forEach(new Consumer[Employee] {
            override def accept(emp: Employee): Unit = {
                println(emp)
            }
        })
        ResponseEntity.ok().body(employeeTrait.employees());
    }
    /*@RequestMapping(value= Array("/hello"), method = Array(RequestMethod.GET))
    def hello():String={
        "Hello World";
    }

    @RequestMapping(value= Array("/sayHello"),method = Array(RequestMethod.POST))
    def sayHello(@RequestBody  name:String):ResponseEntity[String]={
        ResponseEntity.ok().body("Hello" + name +"! How are you?")
    }*/
}
