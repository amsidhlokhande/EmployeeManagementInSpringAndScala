package com.amsidh.mvc

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableJpaRepositories(Array("com.amsidh.mvc.repository"))
@SpringBootApplication
@EnableSwagger2
class EmployeeApp {

}

object EmployeeApp {
    def main(args: Array[String]): Unit = {
        //SpringApplication.run(classOf[EmployeeApp], args: _*)
        val configClasses: Array[Class[_]] = Array(classOf[EmployeeApp])
        SpringApplication.run(configClasses, args);
    }
}
