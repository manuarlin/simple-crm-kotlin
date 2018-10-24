package com.group.crmkotlin.service

import com.group.crmkotlin.model.Customer
import java.util.*

interface ICustomerService {

    fun findAll(): List<Customer>

    fun findByLastNameIgnoreCase(lastName: String): List<Customer>

    fun findByLastNameAndFirstName(lastName: String, firstName: String): List<Customer>

    fun findById(id: String): Optional<Customer>
}
