package com.group.crmkotlin.service

import com.group.crmkotlin.model.Customer
import com.group.crmkotlin.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerService(val customerRepository: CustomerRepository) : ICustomerService {

    override fun findAll(): List<Customer> {
        return customerRepository.findAll().map { Customer(it) }
    }

    override fun findByLastNameIgnoreCase(lastName: String): List<Customer> {
        return customerRepository.findByLastNameIgnoreCase(lastName).map { Customer(it) }
    }

    override fun findByLastNameAndFirstName(lastName: String, firstName: String): List<Customer> {
        return customerRepository.findByLastNameIgnoreCaseAndFirstNameIgnoreCase(lastName, firstName).map { Customer(it) }
    }

    override fun findById(id: String): Optional<Customer> {
        return customerRepository.findById(id.toLong()).map { Customer(it) }
    }
}