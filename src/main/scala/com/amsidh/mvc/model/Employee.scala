package com.amsidh.mvc.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.{Column, Entity, GeneratedValue, GenerationType, Id, Table}
import lombok.Data
import scala.beans.BeanProperty

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "employees")
@SerialVersionUID(value = 1234567890L)
@Data
class Employee(name: String, sal: Double, mobile: Number, email: String) extends Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @BeanProperty
    @Column(name = "ID") var id: Int = _

    @Column(name = "NAME")
    @BeanProperty
    var employeeName: String = name

    @Column(name = "SALARY")
    @BeanProperty
    var salary: Double = sal

    @Column(name = "MOBILE_NUMBER")
    @BeanProperty
    var mobileNumber: Number = mobile

    @Column(name = "EMAILID")
    @BeanProperty
    var emailId: String = email

    def this() {
        this(null, 0.0, 0, null)
    }
}
